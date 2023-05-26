package by.kozlov.spring.utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
@EqualsAndHashCode
@ToString
public class ConnectionManager {

    private final String username;
    private final String password;
    private final String url;
    private final String poolSize;
    private static final Integer DEFAULT_POOL_SIZE = 10;

    private static BlockingQueue<Connection> pool;

    public ConnectionManager(//@Value("${db.username}")
                             String username,
                             //@Value("${db.password}")
                             String password,
                             //@Value("${db.url}")
                             String url,
                             //@Value("${db.pool.size}")
                             String poolSize) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.poolSize = poolSize;
        loadDriver();
        this.initConnectionPool();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initConnectionPool() {
        var poolSize = this.poolSize;
        var size = poolSize == null ? DEFAULT_POOL_SIZE : Integer.parseInt(poolSize);
        pool = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            var connection = open();
            var proxyConnection = Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(),new Class[]{Connection.class},
                    ((proxy, method, args) -> method.getName().equals("close")?
                            pool.add((Connection) proxy): method.invoke(connection,args)));
            pool.add((Connection) proxyConnection);
            //pool.add(open());
        }
    }

    public Connection get() {
        try {
            return pool.take();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
    private Connection open() {
        try {
            return DriverManager.getConnection(url,
                    username,password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

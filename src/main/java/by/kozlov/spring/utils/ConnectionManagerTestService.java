package by.kozlov.spring.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service(ConnectionManagerService.NAME)
@Profile("test")
@PropertySource("classpath:application-test.properties")
public class ConnectionManagerTestService implements ConnectionManagerService{
    private final String username;
    private final String password;
    private final String url;
    private final String poolSize;

    public ConnectionManagerTestService(@Value("${db.username}")
                                              String username,
                                              @Value("${db.password}")
                                              String password,
                                              @Value("${db.url}")
                                              String url,
                                              @Value("${db.pool.size}")
                                              String poolSize) {

        this.username = username;
        this.password = password;
        this.url = url;
        this.poolSize = poolSize;
    }
    @Override
    public ConnectionManager getConnectionManager() {
        return new ConnectionManager(username,password,url,poolSize);
    }
}

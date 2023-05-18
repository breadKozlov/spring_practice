package by.kozlov.spring.database;

import by.kozlov.spring.entity.Company;
import by.kozlov.spring.entity.User;
import by.kozlov.spring.exception.DaoException;
import by.kozlov.spring.utils.ConnectionManager;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepository {

    private final ConnectionManager connectionManager;

    private static String FIND_ALL = """
            SELECT u.id,u.name,u.surname,u.email,c.id,c.name          
            FROM users_spring u
            LEFT JOIN company_spring c ON u.company = c.id
           """;

    private static String FIND_BY_ID = FIND_ALL + """
            WHERE u.id = ?
            """;

    public Optional<User> findById(Integer id) {
        try(var connection = connectionManager.get();
            var statement = connection.prepareStatement(FIND_BY_ID)) {
            User user = null;
            statement.setLong(1,id);
            var result = statement.executeQuery();
            if (result.next())
                user = buildUser(result);
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<User> findAll() {
        try (var connection = connectionManager.get();
             var statement = connection.prepareStatement(FIND_ALL)) {
            List<User> users = new ArrayList<>();
            var result = statement.executeQuery();
            while (result.next())
                users.add(buildUser(result));
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private User buildUser(ResultSet result) throws SQLException {
        var company = Company.builder()
                .id(result.getInt("id"))
                .name(result.getString("name"))
                .build();
        return User.builder()
                .id(result.getInt("id"))
                .name(result.getString("name"))
                .surname(result.getString("surname"))
                .email(result.getString("email"))
                .company(company)
                .build();
    }
}

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
public class CompanyRepository {

    private final ConnectionManager connectionManager;

    private static String FIND_ALL = """
            SELECT id,name          
            FROM company_spring
           """;

    private static String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;

    public Optional<Company> findById(Integer id) {
        try(var connection = connectionManager.get();
            var statement = connection.prepareStatement(FIND_BY_ID)) {
            Company company = null;
            statement.setLong(1,id);
            var result = statement.executeQuery();
            if (result.next())
                company = buildCompany(result);
            return Optional.ofNullable(company);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Company> findAll() {
        try (var connection = connectionManager.get();
             var statement = connection.prepareStatement(FIND_ALL)) {
            List<Company> companies = new ArrayList<>();
            var result = statement.executeQuery();
            while (result.next())
                companies.add(buildCompany(result));
            return companies;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Company buildCompany(ResultSet result) throws SQLException {
        return Company.builder()
                .id(result.getInt("id"))
                .name(result.getString("name"))
                .build();
    }
}

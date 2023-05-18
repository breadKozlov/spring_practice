package by.kozlov;

import by.kozlov.spring.database.CompanyRepository;
import by.kozlov.spring.database.UserRepository;
import by.kozlov.spring.mapper.CompanyReadMapper;
import by.kozlov.spring.mapper.UserReadMapper;
import by.kozlov.spring.service.CompanyService;
import by.kozlov.spring.service.UserService;
import by.kozlov.spring.utils.ConnectionManager;

public class Main {
    public static void main(String[] args) {

        var connectionManager = new ConnectionManager("postgres","password",
                "jdbc:postgresql://localhost:5432/postgres","12");
        var userRepository = new UserRepository(connectionManager);
        var companyReadMapper = new CompanyReadMapper();
        var companyRepository = new CompanyRepository(connectionManager);
        var userReadMapper = new UserReadMapper(companyReadMapper);
        var userService = new UserService(userRepository,userReadMapper);
        var companyService = new CompanyService(companyRepository,companyReadMapper);
        System.out.println(userService.findAll());
        System.out.println(userService.findById(1));
        System.out.println(companyService.findAll());
        System.out.println(companyService.findById(1));
    }
}
package by.kozlov;

import by.kozlov.spring.database.CompanyRepository;
import by.kozlov.spring.database.UserRepository;
import by.kozlov.spring.mapper.CompanyReadMapper;
import by.kozlov.spring.mapper.UserReadMapper;
import by.kozlov.spring.service.CompanyService;
import by.kozlov.spring.service.UserService;
import by.kozlov.spring.utils.ConnectionManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("application.xml")){

            var userService = context.getBean("userService",UserService.class);
            var companyService = context.getBean("companyService",CompanyService.class);

            System.out.println();
            System.out.println(userService.findById(1).orElseThrow());
            System.out.println(companyService.findById(1).orElseThrow());
        }
    }
}
package by.kozlov;

import by.kozlov.spring.config.ApplicationConfiguration;
import by.kozlov.spring.utils.ConnectionManager;
import by.kozlov.spring.utils.ProfileManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)){

            var profileManager = context.getBean(ProfileManager.class);
            var connectionManager1 = context.getBean(ConnectionManager.class);
            System.out.println(connectionManager1);
            profileManager.getActiveProfiles();
        }
    }
}
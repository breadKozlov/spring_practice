package by.kozlov.spring.config;

import by.kozlov.spring.utils.ConnectionManager;
import by.kozlov.spring.utils.ConnectionManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "by.kozlov.spring")
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class ApplicationConfiguration {
    @Bean("connectionManager")
    public ConnectionManager connectionManager(@Autowired ConnectionManagerService connectionManagerService) {
        return connectionManagerService.getConnectionManager();
        }
}



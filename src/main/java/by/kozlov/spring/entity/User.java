package by.kozlov.spring.entity;

import lombok.*;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
@Getter
public class User {

    private  Integer id;
    private  String name;
    private  String surname;
    private  String email;
    private  Company company;

}

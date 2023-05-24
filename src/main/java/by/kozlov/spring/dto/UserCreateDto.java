package by.kozlov.spring.dto;

import by.kozlov.spring.entity.Company;
import lombok.*;
import org.springframework.stereotype.Component;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateDto {
    private  String name;
    private  String surname;
    private  String email;
    private Company company;
}

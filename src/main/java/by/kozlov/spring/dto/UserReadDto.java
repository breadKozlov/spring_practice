package by.kozlov.spring.dto;

import by.kozlov.spring.entity.Company;
import lombok.*;
import org.springframework.stereotype.Component;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserReadDto {

    private Integer id;
    private  String name;
    private  String surname;
    private  String email;
    private CompanyReadDto company;
}

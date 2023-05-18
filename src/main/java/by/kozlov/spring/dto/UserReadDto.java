package by.kozlov.spring.dto;

import by.kozlov.spring.entity.Company;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserReadDto {

    private Integer id;
    private  String name;
    private  String surname;
    private  String email;
    private CompanyReadDto company;
}

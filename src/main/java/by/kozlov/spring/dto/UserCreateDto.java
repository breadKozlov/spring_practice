package by.kozlov.spring.dto;

import by.kozlov.spring.entity.Company;
import jdk.jfr.BooleanFlag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateDto {
    private  String name;
    private  String surname;
    private  String email;
    private Company company;
}

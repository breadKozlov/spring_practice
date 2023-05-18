package by.kozlov.spring.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private  Integer id;
    private  String name;
    private  String surname;
    private  String email;
    private  Company company;

}

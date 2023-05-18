package by.kozlov.spring.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Company {
    private Integer id;
    private String name;
}

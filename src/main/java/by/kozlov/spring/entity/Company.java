package by.kozlov.spring.entity;

import lombok.*;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Component
@Getter
public class Company {
    private Integer id;
    private String name;
}

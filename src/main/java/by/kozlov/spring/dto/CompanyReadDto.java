package by.kozlov.spring.dto;

import lombok.*;
import org.springframework.stereotype.Component;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyReadDto {
    private Integer id;
    private Integer name;
}

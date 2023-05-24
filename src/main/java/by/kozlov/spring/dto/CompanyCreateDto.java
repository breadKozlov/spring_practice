package by.kozlov.spring.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyCreateDto {
    private Integer id;
    private String name;
}

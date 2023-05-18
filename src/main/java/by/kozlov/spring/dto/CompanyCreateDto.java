package by.kozlov.spring.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CompanyCreateDto {
    private Integer id;
    private String name;
}

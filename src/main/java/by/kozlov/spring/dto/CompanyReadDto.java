package by.kozlov.spring.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompanyReadDto {
    private Integer id;
    private Integer name;
}

package by.kozlov.spring.mapper;

import by.kozlov.spring.dto.CompanyReadDto;
import by.kozlov.spring.entity.Company;
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{
    @Override
    public CompanyReadDto mapFrom(Company object) {
        return CompanyReadDto.builder()
                .id(object.getId())
                .name(object.getId())
                .build();
    }
}

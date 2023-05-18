package by.kozlov.spring.mapper;

import by.kozlov.spring.dto.CompanyCreateDto;
import by.kozlov.spring.dto.UserCreateDto;
import by.kozlov.spring.entity.Company;
import by.kozlov.spring.entity.User;

public class CompanyCreateMapper implements Mapper <CompanyCreateDto, Company>{
    @Override
    public Company mapFrom(CompanyCreateDto object) {
        return Company.builder()
                .name(object.getName())
                .build();
    }
}

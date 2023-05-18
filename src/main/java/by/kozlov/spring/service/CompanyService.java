package by.kozlov.spring.service;

import by.kozlov.spring.database.CompanyRepository;
import by.kozlov.spring.dto.CompanyReadDto;
import by.kozlov.spring.dto.UserReadDto;
import by.kozlov.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyReadDto> findById(Integer id) {

        return companyRepository.findById(id).map(companyReadMapper::mapFrom);
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream().map(companyReadMapper::mapFrom)
                .collect(Collectors.toList());
    }
}

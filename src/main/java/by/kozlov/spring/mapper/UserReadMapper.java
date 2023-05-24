package by.kozlov.spring.mapper;

import by.kozlov.spring.dto.UserReadDto;
import by.kozlov.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto mapFrom(User object) {
        return UserReadDto.builder()
                .id(object.getId())
                .name(object.getName())
                .surname(object.getSurname())
                .email(object.getEmail())
                .company(companyReadMapper.mapFrom(object.getCompany()))
                .build();
    }
}

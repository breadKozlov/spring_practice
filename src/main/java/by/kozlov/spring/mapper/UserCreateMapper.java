package by.kozlov.spring.mapper;

import by.kozlov.spring.database.CompanyRepository;
import by.kozlov.spring.dto.UserCreateDto;
import by.kozlov.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateMapper implements Mapper <UserCreateDto, User>{

    private final CompanyRepository companyRepository;

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .name(object.getName())
                .surname(object.getSurname())
                .email(object.getEmail())
                .company(companyRepository.findById(object.getCompany().getId())
                        .orElseThrow(IllegalArgumentException::new))
                .build();
    }
}

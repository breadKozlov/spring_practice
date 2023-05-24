package by.kozlov.spring.service;

import by.kozlov.spring.database.UserRepository;
import by.kozlov.spring.dto.UserReadDto;
import by.kozlov.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;

    public Optional<UserReadDto> findById(Integer id) {

        return userRepository.findById(id).map(userReadMapper::mapFrom);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(userReadMapper::mapFrom)
                .collect(Collectors.toList());
    }
}

package com.epam.spring.web.mvc.electives.service.impl;

import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.model.User;
import com.epam.spring.web.mvc.electives.repository.UserRepository;
import com.epam.spring.web.mvc.electives.service.MappingService;
import com.epam.spring.web.mvc.electives.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MappingService mappingService;

    @Override
    public UserDto getUser(String email) {
        log.info("get User by email {}", email);
        User user = userRepository.getUser(email);
        return mappingService.mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("create User with email {}", userDto.getEmail());
        User user = mappingService.mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mappingService.mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("update User with email {}", email);
        User user = mappingService.mapUserDtoToUser(userDto);

        User oldUser = userRepository.getUser(email);
        user.setEmail(oldUser.getEmail());
        user.setPassword(oldUser.getPassword());

        user = userRepository.updateUser(email, user);
        return mappingService.mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("delete User with email {}", email);
        userRepository.deleteUser(email);
    }
}

package com.epam.spring.web.mvc.electives.service;

import com.epam.spring.web.mvc.electives.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(String email, UserDto userDto);
    void deleteUser(String email);
}

package com.epam.spring.web.mvc.electives.controller;

import com.epam.spring.web.mvc.electives.api.UserApi;
import com.epam.spring.web.mvc.electives.controller.assembler.UserAssembler;
import com.epam.spring.web.mvc.electives.controller.model.UserModel;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        return userAssembler.toModel(userService.getUser(email));
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        return userAssembler.toModel(userService.createUser(userDto));
    }

    @Override
    public UserModel updateUser(String email, UserDto userDto) {
        return userAssembler.toModel(userService.updateUser(email, userDto));
    }

    @Override
    public ResponseEntity<Void> deleteUser(String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}

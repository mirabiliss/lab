package com.epam.spring.web.mvc.electives.controller;

import com.epam.spring.web.mvc.electives.controller.assembler.UserAssembler;
import com.epam.spring.web.mvc.electives.controller.model.UserModel;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import com.epam.spring.web.mvc.electives.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserModel getUser(@PathVariable String email) {
        return userAssembler.toModel(userService.getUser(email));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        return userAssembler.toModel(userService.createUser(userDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserModel updateUser(@PathVariable String email,
                              @RequestBody @Validated(OnUpdate.class) UserDto userDto) {
        return userAssembler.toModel(userService.updateUser(email, userDto));
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}

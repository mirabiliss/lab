package com.epam.spring.web.mvc.electives.api;

import com.epam.spring.web.mvc.electives.controller.model.UserModel;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User management API")
@RequestMapping("api/v1/users")
public interface UserApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    @ApiOperation("Get user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email") })
    UserModel getUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation("Create user")
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    @ApiOperation("Update user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email") })
    UserModel updateUser(@PathVariable String email,
                         @RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @DeleteMapping(value = "/{email}")
    @ApiOperation("Delete user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email") })
    ResponseEntity<Void> deleteUser(@PathVariable String email);

}

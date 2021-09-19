package com.epam.spring.web.mvc.electives.controller.model;

import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserModel extends RepresentationModel<UserModel> {

    @JsonUnwrapped
    private UserDto userDto;

}

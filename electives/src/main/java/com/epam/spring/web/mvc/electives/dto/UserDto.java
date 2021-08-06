package com.epam.spring.web.mvc.electives.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private int roleId;
}

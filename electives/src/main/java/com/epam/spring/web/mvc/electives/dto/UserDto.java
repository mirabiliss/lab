package com.epam.spring.web.mvc.electives.dto;

import com.epam.spring.web.mvc.electives.model.Course;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private RoleDto roleDto;
    List<CourseDto> courses;
}

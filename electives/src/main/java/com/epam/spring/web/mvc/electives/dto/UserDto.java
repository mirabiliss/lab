package com.epam.spring.web.mvc.electives.dto;

import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @NotBlank(message = "'firstName' must not be blank!")
    private String firstName;

    @NotBlank(message = "'lastName' must not be blank!")
    private String lastName;

    @Email(message = "'email' must be a valid email address")
    @NotBlank(message = "'email' must not be blank!", groups = OnCreate.class)
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    private String email;

    @NotBlank(message = "'password' must not be blank!", groups = OnCreate.class)
    @Null(message = "'password' should be absent in request", groups = OnUpdate.class)
    @Size(min = 8, max = 25)
    private String password;

    @NotBlank(message = "'confirmPassword' must not be blank!", groups = OnCreate.class)
    @Null(message = "'confirmPassword' should be absent in request", groups = OnUpdate.class)
    private String confirmPassword;

    private RoleDto role;

    List<CourseDto> courses;
}

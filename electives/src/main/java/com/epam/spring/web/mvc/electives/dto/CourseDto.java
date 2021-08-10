package com.epam.spring.web.mvc.electives.dto;

import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {

    @NotBlank(message = "'naming' must not be blank!", groups = {OnCreate.class, OnUpdate.class})
    private String naming;

    private int daysDuration;

    private List<UserDto> students;

    @NotBlank(message = "'teacherId' must not be blank!", groups = {OnCreate.class, OnUpdate.class})
    private int teacherId;

    @NotBlank(message = "'finished' must not be blank!", groups = {OnCreate.class, OnUpdate.class})
    private boolean finished;
}

package com.epam.spring.web.mvc.electives.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private int id;
    private String naming;
    private int daysDuration;
    private List<UserDto> students;
    private int teacherId;
    private boolean finished;
}

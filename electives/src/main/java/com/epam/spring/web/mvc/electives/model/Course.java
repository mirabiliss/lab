package com.epam.spring.web.mvc.electives.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String naming;
    private int daysDuration;
    private List<User> students;
    private int teacherId;
    private boolean finished;
}

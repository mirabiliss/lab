package com.epam.spring.web.mvc.electives.service;

import com.epam.spring.web.mvc.electives.dto.CourseDto;

public interface CourseService {
    CourseDto getCourse(String naming);
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(String naming, CourseDto courseDto);
    void deleteCourse(String naming);
}

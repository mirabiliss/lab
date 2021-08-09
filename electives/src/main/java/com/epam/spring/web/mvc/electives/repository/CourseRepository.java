package com.epam.spring.web.mvc.electives.repository;

import com.epam.spring.web.mvc.electives.model.Course;

public interface CourseRepository {
    Course getCourse(String naming);
    Course createCourse(Course course);
    Course updateCourse(String naming, Course course);
    void deleteCourse(String naming);
}

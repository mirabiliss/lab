package com.epam.spring.web.mvc.electives.repository.impl;

import com.epam.spring.web.mvc.electives.model.Course;
import com.epam.spring.web.mvc.electives.repository.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseRepositoryImpl implements CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    @Override
    public Course getCourse(String naming) {
        return courses.stream()
                .filter(user -> user.getNaming().equals(naming))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course '" + naming + "' was not found!"));
    }

    @Override
    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course updateCourse(String naming, Course course) {
        boolean isDeleted = courses.removeIf(u -> u.getNaming().equals(naming));
        if (isDeleted) {
            courses.add(course);
        } else {
            throw new RuntimeException("Course '" + naming + "' was not found!");
        }
        return course;
    }

    @Override
    public void deleteCourse(String naming) {
        courses.removeIf(user -> user.getNaming().equals(naming));
    }
}

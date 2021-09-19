package com.epam.spring.web.mvc.electives.controller;

import com.epam.spring.web.mvc.electives.api.CourseApi;
import com.epam.spring.web.mvc.electives.controller.assembler.CourseAssembler;
import com.epam.spring.web.mvc.electives.controller.model.CourseModel;
import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController implements CourseApi {

    private final CourseService courseService;
    private final CourseAssembler courseAssembler;

    @Override
    public CourseModel getCourse(String naming) {
        return courseAssembler.toModel(courseService.getCourse(naming));
    }

    @Override
    public CourseModel createCourse(CourseDto courseDto) {
        return courseAssembler.toModel(courseService.createCourse(courseDto));
    }

    @Override
    public CourseModel updateCourse(String naming, CourseDto courseDto) {
        return courseAssembler.toModel(courseService.updateCourse(naming, courseDto));
    }

    @Override
    public ResponseEntity<Void> deleteCourse(String naming) {
        courseService.deleteCourse(naming);
        return ResponseEntity.noContent().build();
    }
}

package com.epam.spring.web.mvc.electives.controller;

import com.epam.spring.web.mvc.electives.controller.assembler.CourseAssembler;
import com.epam.spring.web.mvc.electives.controller.model.CourseModel;
import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import com.epam.spring.web.mvc.electives.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseAssembler courseAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{naming}")
    public CourseModel getCourse(@PathVariable String naming) {
        return courseAssembler.toModel(courseService.getCourse(naming));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseModel createCourse(@RequestBody @Validated(OnCreate.class) CourseDto courseDto) {
        return courseAssembler.toModel(courseService.createCourse(courseDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{naming}")
    public CourseModel updateCourse(@PathVariable String naming,
                                  @RequestBody @Validated(OnUpdate.class) CourseDto courseDto) {
        return courseAssembler.toModel(courseService.updateCourse(naming, courseDto));
    }

    @DeleteMapping(value = "/{naming}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String naming) {
        courseService.deleteCourse(naming);
        return ResponseEntity.noContent().build();
    }
}

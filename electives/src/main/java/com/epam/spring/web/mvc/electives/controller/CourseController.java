package com.epam.spring.web.mvc.electives.controller;

import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{naming}")
    public CourseDto getCourse(@PathVariable String naming) {
        return courseService.getCourse(naming);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{naming}")
    public CourseDto updateCourse(@PathVariable String naming, @RequestBody CourseDto courseDto) {
        return courseService.updateCourse(naming, courseDto);
    }

    @DeleteMapping(value = "/{naming}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String naming) {
        courseService.deleteCourse(naming);
        return ResponseEntity.noContent().build();
    }
}

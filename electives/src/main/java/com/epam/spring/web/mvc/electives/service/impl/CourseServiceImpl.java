package com.epam.spring.web.mvc.electives.service.impl;

import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.model.Course;
import com.epam.spring.web.mvc.electives.repository.CourseRepository;
import com.epam.spring.web.mvc.electives.service.CourseService;
import com.epam.spring.web.mvc.electives.service.MappingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MappingService mappingService;

    @Override
    public CourseDto getCourse(String naming) {
        log.info("get Course by naming {}", naming);
        Course course = courseRepository.getCourse(naming);
        return mappingService.mapCourseToCourseDto(course);    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        log.info("create Course with naming {}", courseDto.getNaming());
        Course course = mappingService.mapCourseDtoToCourse(courseDto);
        course = courseRepository.createCourse(course);
        return mappingService.mapCourseToCourseDto(course);    }

    @Override
    public CourseDto updateCourse(String naming, CourseDto courseDto) {
        log.info("update Course with naming {}", naming);
        Course course = mappingService.mapCourseDtoToCourse(courseDto);
        course = courseRepository.updateCourse(naming, course);
        return mappingService.mapCourseToCourseDto(course);
    }

    @Override
    public void deleteCourse(String naming) {
        log.info("delete Course with naming {}", naming);
        courseRepository.deleteCourse(naming);
    }
}

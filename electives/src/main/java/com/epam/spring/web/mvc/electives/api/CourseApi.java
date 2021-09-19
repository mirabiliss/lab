package com.epam.spring.web.mvc.electives.api;

import com.epam.spring.web.mvc.electives.controller.model.CourseModel;
import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.dto.group.OnCreate;
import com.epam.spring.web.mvc.electives.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Course management API")
@RequestMapping("api/v1/courses")
public interface CourseApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{naming}")
    @ApiOperation("Get course")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "naming", paramType = "path", required = true, value = "Course naming") })
    CourseModel getCourse(@PathVariable String naming);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation("Create course")
    CourseModel createCourse(@RequestBody @Validated(OnCreate.class) CourseDto courseDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{naming}")
    @ApiOperation("Update course")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "naming", paramType = "path", required = true, value = "Course naming") })
    CourseModel updateCourse(@PathVariable String naming,
                             @RequestBody @Validated(OnUpdate.class) CourseDto courseDto);

    @DeleteMapping(value = "/{naming}")
    @ApiOperation("Delete course")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "naming", paramType = "path", required = true, value = "Course naming") })
    ResponseEntity<Void> deleteCourse(@PathVariable String naming);

}

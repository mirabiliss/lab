package com.epam.spring.web.mvc.electives.controller.assembler;

import com.epam.spring.web.mvc.electives.controller.CourseController;
import com.epam.spring.web.mvc.electives.controller.UserController;
import com.epam.spring.web.mvc.electives.controller.model.CourseModel;
import com.epam.spring.web.mvc.electives.dto.CourseDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CourseAssembler extends RepresentationModelAssemblerSupport<CourseDto, CourseModel> {

    public static final String GET_COURSE_REL = "get_course";
    public static final String CREATE_COURSE_REL = "create_course";
    public static final String UPDATE_COURSE_REL = "update_course";
    public static final String DELETE_COURSE_REL = "delete_course";

    public CourseAssembler() {
        super(CourseController.class, CourseModel.class);
    }

    @Override
    public CourseModel toModel(CourseDto entity) {
        CourseModel courseModel = new CourseModel(entity);

        Link get = linkTo(methodOn(CourseController.class).getCourse(entity.getNaming())).withRel(GET_COURSE_REL);
        Link create = linkTo(methodOn(CourseController.class).createCourse(entity)).withRel(CREATE_COURSE_REL);
        Link update = linkTo(methodOn(CourseController.class).updateCourse(entity.getNaming(), entity)).withRel(UPDATE_COURSE_REL);
        Link delete = linkTo(methodOn(CourseController.class).deleteCourse(entity.getNaming())).withRel(DELETE_COURSE_REL);

        courseModel.add(get, create, update, delete);

        return courseModel;
    }
}

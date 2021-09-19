package com.epam.spring.web.mvc.electives.controller.assembler;

import com.epam.spring.web.mvc.electives.controller.UserController;
import com.epam.spring.web.mvc.electives.controller.model.UserModel;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public static final String GET_USER_REL = "get_user";
    public static final String CREATE_USER_REL = "create_user";
    public static final String UPDATE_USER_REL = "update_user";
    public static final String DELETE_USER_REL = "delete_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel(GET_USER_REL);
        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_USER_REL);
        Link update = linkTo(methodOn(UserController.class).updateUser(entity.getEmail(), entity)).withRel(UPDATE_USER_REL);
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getEmail())).withRel(DELETE_USER_REL);

        userModel.add(get, create, update, delete);

        return userModel;
    }
}

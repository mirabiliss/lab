package com.epam.spring.web.mvc.electives.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {

    @NotBlank(message = "'naming' must not be blank!")
    private String naming;

}

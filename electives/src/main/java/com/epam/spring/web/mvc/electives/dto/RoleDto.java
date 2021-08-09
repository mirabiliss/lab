package com.epam.spring.web.mvc.electives.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {
    private int id;
    private String naming;
}

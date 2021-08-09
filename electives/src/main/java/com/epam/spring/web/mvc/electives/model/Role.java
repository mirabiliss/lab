package com.epam.spring.web.mvc.electives.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private int id;
    private String naming;
}

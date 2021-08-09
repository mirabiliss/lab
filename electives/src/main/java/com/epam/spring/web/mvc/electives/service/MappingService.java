package com.epam.spring.web.mvc.electives.service;

import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.dto.RoleDto;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.model.Course;
import com.epam.spring.web.mvc.electives.model.Role;
import com.epam.spring.web.mvc.electives.model.User;

public interface MappingService {
    UserDto mapUserToUserDto(User user);
    User mapUserDtoToUser(UserDto userDto);
    RoleDto mapRoleToRoleDto(Role role);
    Role mapRoleDtoToRole(RoleDto roleDto);
    CourseDto mapCourseToCourseDto(Course course);
    Course mapCourseDtoToCourse(CourseDto courseDto);
}

package com.epam.spring.web.mvc.electives.service.impl;

import com.epam.spring.web.mvc.electives.dto.CourseDto;
import com.epam.spring.web.mvc.electives.dto.RoleDto;
import com.epam.spring.web.mvc.electives.dto.UserDto;
import com.epam.spring.web.mvc.electives.model.Course;
import com.epam.spring.web.mvc.electives.model.Role;
import com.epam.spring.web.mvc.electives.model.User;
import com.epam.spring.web.mvc.electives.service.MappingService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingServiceImpl implements MappingService {
    
    @Override
    public UserDto mapUserToUserDto(User user) {
        List<CourseDto> courseDtos = user.getCourses().stream()
                .map(this::mapCourseToCourseDto)
                .collect(Collectors.toList());
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(mapRoleToRoleDto(user.getRole()))
                .courses(courseDtos)
                .build();
    }

    @Override
    public User mapUserDtoToUser(UserDto userDto) {
        List<Course> courses = userDto.getCourses().stream()
                .map(this::mapCourseDtoToCourse)
                .collect(Collectors.toList());
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(mapRoleDtoToRole(userDto.getRole()))
                .courses(courses)
                .build();
    }

    @Override
    public RoleDto mapRoleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);
        return roleDto;
    }

    @Override
    public Role mapRoleDtoToRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        return role;
    }

    @Override
    public CourseDto mapCourseToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        BeanUtils.copyProperties(course, courseDto);
        return courseDto;
    }

    @Override
    public Course mapCourseDtoToCourse(CourseDto courseDto) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        return course;
    }
}

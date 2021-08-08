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

import java.util.ArrayList;
import java.util.List;

@Service
public class MappingServiceImpl implements MappingService {
    @Override
    public UserDto mapUserToUserDto(User user) {
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : user.getCourses()) {
            courseDtos.add(mapCourseToCourseDto(course));
        }
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .roleDto(mapRoleToRoleDto(user.getRole()))
                .courses(courseDtos)
                .build();
    }

    @Override
    public User mapUserDtoToUser(UserDto userDto) {
        List<Course> courses = new ArrayList<>();
        for (CourseDto courseDto : userDto.getCourses()) {
            courses.add(mapCourseDtoToCourse(courseDto));
        }
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(mapRoleDtoToRole(userDto.getRoleDto()))
                .courses(courses)
                .build();
    }

    @Override
    public RoleDto mapRoleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleDto, role);
        return roleDto;
    }

    @Override
    public Role mapRoleDtoToRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(role, roleDto);
        return role;
    }

    @Override
    public CourseDto mapCourseToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        BeanUtils.copyProperties(courseDto, course);
        return courseDto;
    }

    @Override
    public Course mapCourseDtoToCourse(CourseDto courseDto) {
        Course course = new Course();
        BeanUtils.copyProperties(course, courseDto);
        return course;
    }
}

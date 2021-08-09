package com.epam.spring.web.mvc.electives.repository;

import com.epam.spring.web.mvc.electives.model.User;

public interface UserRepository {
    User getUser(String email);
    User createUser(User user);
    User updateUser(String email, User user);
    void deleteUser(String email);
}

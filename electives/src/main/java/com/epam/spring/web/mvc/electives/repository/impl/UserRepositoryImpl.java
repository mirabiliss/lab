package com.epam.spring.web.mvc.electives.repository.impl;

import com.epam.spring.web.mvc.electives.model.User;
import com.epam.spring.web.mvc.electives.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return list.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with email '" + email + "' was not found!"));
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = list.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("User with email '" + email + "' was not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        list.removeIf(user -> user.getEmail().equals(email));
    }
}

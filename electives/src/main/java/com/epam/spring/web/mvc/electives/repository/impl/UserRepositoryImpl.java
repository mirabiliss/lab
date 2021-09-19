package com.epam.spring.web.mvc.electives.repository.impl;

import com.epam.spring.web.mvc.electives.exception.UserNotFoundException;
import com.epam.spring.web.mvc.electives.model.User;
import com.epam.spring.web.mvc.electives.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = users.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            users.add(user);
        } else {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }
}

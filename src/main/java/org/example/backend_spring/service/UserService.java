package org.example.backend_spring.service;

import org.example.backend_spring.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User findUserById(Long id);

    List<User> findAllUsers();

    void deleteUser(Long id);

    User findByUsername(String username);
}

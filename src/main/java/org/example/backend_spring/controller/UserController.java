package org.example.backend_spring.controller;

import org.example.backend_spring.model.User;
import org.example.backend_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);

    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        List<User>userList = userService.findAllUsers();
        return userList;
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById() {

    }
}

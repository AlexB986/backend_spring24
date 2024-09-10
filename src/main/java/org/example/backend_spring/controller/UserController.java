package org.example.backend_spring.controller;

import org.example.backend_spring.model.User;
import org.example.backend_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public void addUser(@ModelAttribute User user) {
        userService.addUser(user);

    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);

    }

    @GetMapping("/read")
    public List<User> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        return userList;
    }

    @GetMapping("/read/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable  Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/ver/{username}")
    public User findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }
}

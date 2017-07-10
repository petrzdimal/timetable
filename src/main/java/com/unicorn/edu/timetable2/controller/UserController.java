package com.unicorn.edu.timetable2.controller;

import com.unicorn.edu.timetable2.repository.entity.User;
import com.unicorn.edu.timetable2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping(path = "/logged-in", method = RequestMethod.POST)
    public String loginSuccess() {
        return "Successfully logged in...";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/create-user", method = RequestMethod.POST)
    public List<User> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return userService.getAllUsers();
    }

}

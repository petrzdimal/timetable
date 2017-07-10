package com.unicorn.edu.timetable2.service;

import com.unicorn.edu.timetable2.repository.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void saveUser(User user);

}

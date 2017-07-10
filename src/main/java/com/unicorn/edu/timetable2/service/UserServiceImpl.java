package com.unicorn.edu.timetable2.service;

import com.unicorn.edu.timetable2.repository.RoleRepository;
import com.unicorn.edu.timetable2.repository.UserRepository;
import com.unicorn.edu.timetable2.repository.entity.Role;
import com.unicorn.edu.timetable2.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {
        prepareTestUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private void prepareTestUsers() {
        prepareRoles();
        userRepository.save(prepareUsers());
    }

    private void prepareRoles() {
        Role r1 = new Role();
        r1.setName("ADMIN");
        roleRepository.save(r1);

        Role r2 = new Role();
        r2.setName("USER");
        roleRepository.save(r2);
    }

    private List<User> prepareUsers() {
        List<User> users = new ArrayList<>();

        User u1 = new User();
        u1.setFirstName("Petr");
        u1.setLastName("Zdimal");
        u1.setUsername("zdimal");
        u1.setPassword(bCryptPasswordEncoder.encode("heslo"));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("ADMIN"));
        u1.setRoles(roles);


        User u2 = new User();
        u2.setFirstName("Pavel");
        u2.setLastName("Kozel");
        u2.setUsername("kozel");
        u2.setPassword(bCryptPasswordEncoder.encode("tajne"));
        List<Role> roles2 = new ArrayList<>();
        roles2.add(roleRepository.findByName("USER"));
        u2.setRoles(roles2);

        users.add(u1);
        users.add(u2);

        return users;
    }
}

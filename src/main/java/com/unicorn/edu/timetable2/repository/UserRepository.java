package com.unicorn.edu.timetable2.repository;

import com.unicorn.edu.timetable2.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}

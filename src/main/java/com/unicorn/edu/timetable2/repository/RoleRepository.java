package com.unicorn.edu.timetable2.repository;

import com.unicorn.edu.timetable2.repository.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}

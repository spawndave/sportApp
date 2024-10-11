package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Athlete getAthleteByUsername(String username);
    Coach getCoachByUsername(String username);
    User findByUsername(String username);
    List<User> findUsersByRoleNot(Role role);
}
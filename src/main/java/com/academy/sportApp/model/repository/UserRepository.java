package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaRepository<User, Long> {
    Athlete getAthleteByUsername(String username);
    Coach getCoachByUsername(String username);
    User findByUsername(String username);
    Optional<User> getUserByUsername(String username);

    User findUserByEmail(String email);
    List<User> findUsersByRoleNot(Role role);
}
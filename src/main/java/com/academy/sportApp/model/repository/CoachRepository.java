package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CoachRepository extends JpaRepository<Coach, Long> {
    Coach getCoachById(Long id);
    Optional<Coach> getCoachByUsername(String nickname);

}
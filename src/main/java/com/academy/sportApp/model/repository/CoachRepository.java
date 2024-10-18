package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoachRepository extends JpaRepository<Coach, Long> {
    Coach getCoachById(Long id);
    Coach getCoachByUsername(String nickname);

}
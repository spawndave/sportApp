package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Coach findCoachById(Long id);
}

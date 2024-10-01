package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.AthleteWithCoach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachAthleteSportRepository extends JpaRepository<AthleteWithCoach, Long> {

}
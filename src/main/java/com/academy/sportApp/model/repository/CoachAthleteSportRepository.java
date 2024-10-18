package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachAthleteSportRepository extends JpaRepository<AthleteWithCoach, Long> {
    AthleteWithCoach getAthleteWithCoachByCoachAndAthleteData(Coach coach, Athlete athleteData);
}
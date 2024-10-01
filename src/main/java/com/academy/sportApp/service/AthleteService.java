package com.academy.sportApp.service;


import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.AthleteWithCoach;

import java.util.List;

public interface AthleteService {
    List<Athlete> getAllAthletes();
    Athlete getAthleteById(Long id);
    Athlete getAthleteByUsername(String username);
    List<Athlete> getAthletesBySportWithoutCoach(Long sportId);
    AthleteWithCoach getAthletFromCoachAthletesById(List<AthleteWithCoach> athletes, Long athlete_id);
}
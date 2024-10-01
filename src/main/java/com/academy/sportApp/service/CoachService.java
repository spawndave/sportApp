package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.Training;

import java.util.List;
import java.util.Set;

public interface CoachService {
    List<Coach> getAllCoaches();
    Coach getCoachById(Long id);
    Coach getCoachByUsername(String username);
    void save(Coach coach);
    void saveAthlete(AthleteWithCoach athlete);
    Training getCoachTrainingById(Long trainingId, Coach coach);
    void addTrainingPatricipant(Training training, Long user_id);
    Set<AthleteWithCoach> getAllCoachAthletesNotInTraining(Training training);
}
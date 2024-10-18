package com.academy.sportApp.service;

import com.academy.sportApp.dto.TrainingDto;
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
    Set<AthleteWithCoach> getAllCoachAthletesNotInTraining(Training training);
    void addAthleteForTrainings(Coach coach, Long athleteId);
    void addTraining(Coach coach, TrainingDto trainingDto);
    void addAthlete(Coach coach, Long id);
    void rejectTrainingRequest(Long trainingRequestId);
    void approveTrainingRequest(Long trainingRequestId);
}
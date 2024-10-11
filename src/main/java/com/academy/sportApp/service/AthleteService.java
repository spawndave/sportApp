package com.academy.sportApp.service;


import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.entity.TrainingParticipant;

import java.util.List;

public interface AthleteService {
    List<Athlete> getAllAthletes();
    Athlete getAthleteById(Long id);
    Athlete getAthleteByUsername(String username);
    TrainingParticipant getTrainingParticipant(Long participantId);
    List<Athlete> getAthletesBySportWithoutCoach(Long sportId);
    AthleteWithCoach getTrainingJournal(Long id);
}
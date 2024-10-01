package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TrainingService {
    List<Training> getAllTrainings();
    Training getTraningById(Long id);
    void addParticipantToTraining(Long trainingId, Long participantId, Long coachId);
    void removeParticipantFromTraining(Training training, Long participantId);
    Training updateTraining(Training training);
}
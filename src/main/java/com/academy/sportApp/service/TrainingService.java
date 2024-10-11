package com.academy.sportApp.service;

import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.Training;
import com.academy.sportApp.model.entity.TrainingParticipant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TrainingService {
    List<Training> getAllTrainings();
    Training getTrainingById(Long id);
    void addParticipantToTraining(Long trainingId, Long participantId, Coach coach);
    void removeParticipantFromTraining(Long trainingId, Long participantId);
    void updateTraining(Training training);
    void updateTrainingData(TrainingParticipant participant, Long participantId);
}
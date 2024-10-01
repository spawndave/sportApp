package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Training;
import com.academy.sportApp.model.entity.TrainingParticipant;
import com.academy.sportApp.model.entity.TrainingSession;
import com.academy.sportApp.model.repository.TrainingParticipantRepository;
import com.academy.sportApp.model.repository.TrainingRepository;
import com.academy.sportApp.model.repository.TrainingSessionRepository;
import com.academy.sportApp.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingParticipantRepository trainingParticipantRepository;
    private  final TrainingSessionRepository trainingSessionRepository;
    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getTraningById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public void addParticipantToTraining(Long trainingId, Long athleteId, Long coachId) {
        TrainingSession trainingSession = new TrainingSession(trainingId, athleteId);
        trainingSessionRepository.save(trainingSession);
        TrainingParticipant participant =TrainingParticipant.builder().
                trainingId(trainingId).
                coachId(coachId).
                athleteId(athleteId).
                build();
        trainingParticipantRepository.save(participant);
    }
    @Override
    public void removeParticipantFromTraining(Training training, Long participantId) {
        TrainingParticipant participant = trainingParticipantRepository.findById(participantId).orElse(null);
        training.getParticipants().remove(participant);
        trainingParticipantRepository.deleteById(participantId);
    }

    @Override
    public Training updateTraining(Training training) {
        Training updatedTraning = getTraningById(training.getId());
        updatedTraning.setName(training.getName());
        updatedTraning.setDescription(training.getDescription());
        updatedTraning.setDate(training.getDate());
        updatedTraning.setLocation(training.getLocation());
        updatedTraning.setUpdatedAt(LocalDate.now().toString());
        trainingRepository.save(updatedTraning);
        return updatedTraning;
    }
}
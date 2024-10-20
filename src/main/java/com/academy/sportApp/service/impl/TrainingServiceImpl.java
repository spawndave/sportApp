package com.academy.sportApp.service.impl;

import com.academy.sportApp.dto.TrainingDto;
import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.model.enums.TrainingDifficulty;
import com.academy.sportApp.model.enums.TrainingStatus;
import com.academy.sportApp.model.repository.*;
import com.academy.sportApp.service.TrainingService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingParticipantRepository trainingParticipantRepository;
    private final TrainingSessionRepository trainingSessionRepository;
    private final AthleteRepository athleteRepository;
    private final CoachAthleteSportRepository coachAthleteSportRepository;
    private final UserService userService;

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getTrainingById(Long trainingId) {
        return trainingRepository.getReferenceById(trainingId);
    }

    @Override
    public void addParticipantToTraining(Long trainingId, Long athleteId, Coach coach) {
        Training training = trainingRepository.findById(trainingId).orElse(null);
        Athlete athleteData = athleteRepository.getReferenceById(athleteId);
        AthleteWithCoach athlete = coachAthleteSportRepository.getAthleteWithCoachByCoachAndAthleteData(coach, athleteData);
        TrainingSession trainingSession = TrainingSession.builder()
            .data(athleteData)
            .difficulty(TrainingDifficulty.DEFAULT)
            .training(training).build();
            trainingSession.setCreatedAt(LocalDate.now());
        TrainingParticipant participant = TrainingParticipant.builder()
            .training(training)
            .athlete(athlete)
            .athleteData(athleteData)
            .trainingSession(trainingSession)
            .coach(coach)
            .status(TrainingStatus.NOT_COMPLETED).build();
        trainingParticipantRepository.save(participant);
    }
    @Override
    public void removeParticipantFromTraining(Long trainingId, Long participantId) {
        TrainingParticipant participant = trainingParticipantRepository.findById(participantId).orElse(null);
        Training training = getTrainingById(trainingId);
        training.getParticipants().remove(participant);
        trainingParticipantRepository.deleteById(participantId);
        //trainingRepository.save(training);
    }

    @Override
    public void updateTraining(Training training) {
        Training updatedTraning = getTrainingById(training.getId());
        updatedTraning.setName(training.getName());
        updatedTraning.setDescription(training.getDescription());
        updatedTraning.setDate(training.getDate());
        updatedTraning.setLocation(training.getLocation());
        trainingRepository.save(updatedTraning);
    }

    @Override
    public void updateTrainingData(TrainingParticipant updatedParticipant, Long participantId) {
        TrainingParticipant participant = trainingParticipantRepository
                .findById(participantId).orElse(null);
        TrainingSession trainingSession = trainingSessionRepository
                .findById(updatedParticipant.getTrainingSession().getId()).orElse(null);
        participant.setStatus(updatedParticipant.getStatus());
        trainingSession.setSessionDate(updatedParticipant.getTrainingSession().getSessionDate());
        trainingSession.setComments(updatedParticipant.getTrainingSession().getComments());
        trainingSession.setDifficulty(updatedParticipant.getTrainingSession().getDifficulty());
        participant.setTrainingSession(trainingSession);
        trainingParticipantRepository.save(participant);
    }

    @Override
    public boolean isCurrUserTrainingParticipant(Training training, Long currUserId) {
        Set<TrainingParticipant> set =  training.getParticipants().stream()
                .filter(part-> part.getAthleteData().getId() == currUserId).collect(Collectors.toSet());
        return set.size() > 0;
    }

    @Override
    public Training convertDtoTraining(TrainingDto trainingDto) {
        Training training = new Training();
        training.setName(trainingDto.getName());
        training.setDescription(trainingDto.getDescription());
        training.setLocation(training.getLocation());
        training.setDate(trainingDto.getDate());
        return training;
    }

    public List<TrainingParticipant> getTrainingsByAthleteIdAndCoachId(Athlete athleteData, Coach coach) {
        return trainingParticipantRepository.findTrainingParticipantByAthleteAndCoach(athleteData, coach);
    }
}
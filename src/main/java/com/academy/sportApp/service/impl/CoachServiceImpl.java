package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.model.repository.CoachAthleteSportRepository;
import com.academy.sportApp.model.repository.CoachRepository;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final CoachAthleteSportRepository athleteCoachRepository;
    private final TrainingService trainingService;

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach getCoachById(Long id) {
        return coachRepository.getCoachById(id);
    }

    @Override
    public Coach getCoachByUsername(String username) {
        return coachRepository.getCoachByUsername(username);
    }

    @Override
    public void save(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public void saveAthlete(AthleteWithCoach athlete) {
        athleteCoachRepository.save(athlete);
    }

    @Override
    public Training getCoachTrainingById(Long trainingId, Coach coach) {
        return coach.getTrainings().stream()
                .filter(training->training.getId().equals(trainingId)).findAny().get();
    }

    @Override
    public void addTrainingPatricipant(Training training, Long user_id) {
        TrainingSession trainingSession = new TrainingSession();
        TrainingParticipant participant = TrainingParticipant.builder().
                athleteId(user_id).
                coachId(training.getCoachId()).
                trainingSession(trainingSession).
                build();
        training.getParticipants().add(participant);
    }

    @Override
    public Set<AthleteWithCoach> getAllCoachAthletesNotInTraining(Training training) {
        Set<TrainingParticipant> trainingParticipants = training.getParticipants();
        Set<AthleteWithCoach> coachAthletesList = training.getCoach().getAthletes();
        Set<AthleteWithCoach> filteredList = new HashSet<>();
        for (AthleteWithCoach athlete : coachAthletesList) {
            for (TrainingParticipant participant : trainingParticipants) {
                if (Long.compare(participant.getAthleteId(), athlete.getAthleteId()) != 0) {
                    filteredList.add(athlete);
                }
            }
        }

        return filteredList;
    }


}
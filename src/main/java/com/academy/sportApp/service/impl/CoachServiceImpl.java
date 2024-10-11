package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.Training;
import com.academy.sportApp.model.repository.CoachAthleteSportRepository;
import com.academy.sportApp.model.repository.CoachRepository;
import com.academy.sportApp.service.AthleteService;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final CoachAthleteSportRepository athleteCoachRepository;
    private final TrainingService trainingService;
    private final AthleteService athleteService;

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
                .filter(training -> training.getId().equals(trainingId)).findAny().get();
    }


    @Override
    public Set<AthleteWithCoach> getAllCoachAthletesNotInTraining(Training training) {
        Set<AthleteWithCoach> trainingParticipants = training.getParticipants()
                .stream().map(p -> p.getAthlete()).collect(Collectors.toSet());
        Set<AthleteWithCoach> resultList = training.getCoach().getAthletes();
        resultList.removeAll(trainingParticipants);

        return resultList;
    }

    @Override
    public void addAthleteForTrainings(Coach coach, Long athleteId) {
        AthleteWithCoach athlete = new AthleteWithCoach();
        athlete.builder()
                .athleteData(athleteService.getAthleteById(athleteId))
                .coach(coach)
                .sport(coach.getSport())
                .build();
        saveAthlete(athlete);
        coach.getAthletes().add(athlete);
    }

}
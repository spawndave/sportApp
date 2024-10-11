package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.entity.TrainingParticipant;
import com.academy.sportApp.model.repository.AthleteRepository;
import com.academy.sportApp.model.repository.CoachAthleteSportRepository;
import com.academy.sportApp.model.repository.TrainingParticipantRepository;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteServiceImpl implements AthleteService {
    private final AthleteRepository athleteRepository;
    private final UserRepository userRepository;
    private final TrainingParticipantRepository trainingParticipantRepository;
    private  final CoachAthleteSportRepository coachAthleteSportRepository;

    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    @Override
    public Athlete getAthleteById(Long athlete_id) {
        return athleteRepository.getReferenceById(athlete_id);
    }

    @Override
    public Athlete getAthleteByUsername(String username) {
        return userRepository.getAthleteByUsername(username);
    }

    @Override
    public List<Athlete> getAthletesBySportWithoutCoach(Long sportId) {
        return athleteRepository.getAthletesBySportWithoutCoach(sportId);
    }

    @Override
    public AthleteWithCoach getTrainingJournal(Long id) {
        return coachAthleteSportRepository.getReferenceById(id);
    }

    @Override
    public TrainingParticipant getTrainingParticipant(Long participantId) {
        return trainingParticipantRepository.getTrainingParticipantById(participantId);
    }


}
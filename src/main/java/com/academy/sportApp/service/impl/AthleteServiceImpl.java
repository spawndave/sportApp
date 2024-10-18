package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.model.repository.*;
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
    private final TrainingRequestRepository trainingRequestRepository;

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
    public void createTrainingRequest(Athlete athlete, Coach coach) {
        TrainingRequest request = new TrainingRequest();
        request.setCoach(coach);
        request.setAthleteData(athlete);
        trainingRequestRepository.save(request);
    }

    @Override
    public TrainingParticipant getTrainingParticipant(Long participantId) {
        return trainingParticipantRepository.getTrainingParticipantById(participantId);
    }


}
package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.AthleteWithCoach;
import com.academy.sportApp.model.repository.AthleteRepository;
import com.academy.sportApp.model.repository.CoachAthleteSportRepository;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteServiceImpl implements AthleteService {
    private final AthleteRepository athleteRepository;
    private final CoachAthleteSportRepository coachAthleteSportRepository;
    private final UserRepository userRepository;

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
        return athleteRepository.getAthletesBySportIdNotIn(sportId);
    }

    @Override
    public AthleteWithCoach getAthletFromCoachAthletesById(List<AthleteWithCoach>athletes, Long athlete_id) {
        return athletes.stream().filter(athlete-> athlete.getAthleteId() == athlete_id).findFirst().get();
    }


}
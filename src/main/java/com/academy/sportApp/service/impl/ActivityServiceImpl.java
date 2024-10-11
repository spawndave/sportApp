package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.model.repository.ActivityRepository;
import com.academy.sportApp.model.repository.SportRepository;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final SportRepository sportRepository;
    private final AthleteService athleteService;


    @Override
    public List<Sport> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void addAthleteToSport(String username, Long activityId ) {
        Athlete athlete = athleteService.getAthleteByUsername(username);
        Sport sport = activityRepository.findById(activityId).get();
        sport.getAthletes().add(athlete);
        activityRepository.save(sport);
    }

    @Override
    public List<Sport> getActivitiesWithoutCoach(Long athleteId) {
        return sportRepository.getActivitiesWithoutCoach(athleteId);
    }

    @Override
    public Sport getSportByName(String sportName) {
        return sportRepository.getSportByName(sportName);
    }
}
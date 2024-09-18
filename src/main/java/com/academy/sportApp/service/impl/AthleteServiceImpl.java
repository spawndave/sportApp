package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.repository.AthleteRepository;
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

    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }



}

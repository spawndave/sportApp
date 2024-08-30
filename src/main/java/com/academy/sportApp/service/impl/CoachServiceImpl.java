package com.academy.sportApp.service.impl;

import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.CoachRepository;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;


    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }
}

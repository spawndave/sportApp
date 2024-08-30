package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.Athlete;
import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.model.repository.UserRepository;
import com.academy.sportApp.service.AthleteService;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CoachService coachService;
    private final AthleteService athleteService;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value="/coaches")
    public List<Coach> getCoached(){
        return coachService.getAllCoaches();
    }

    @GetMapping(value="/athletes")
    public List<Athlete> getAthletes(){
        return athleteService.getAllAthletes();
    }
}

package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.AthleteService;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ActivityService activityService;
    private final CoachService coachService;
    private final AthleteService athleteService;


    @GetMapping
    public String index(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/athlete/{id}")
    public String showAthleteData(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);


        model.addAttribute("user", user);
        model.addAttribute("editMode", "UPDATE");
        return "users/athlete/info";
    }


    @GetMapping("athlete/registration")
    public String registrationUser(Model model){
        model.addAttribute("user", new User());
        return "users/edit";
    }


    @PostMapping("/athlete/registration")
    public String registrationAthlete( User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("coach/registration")
    public String registrationCoach( User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }



}
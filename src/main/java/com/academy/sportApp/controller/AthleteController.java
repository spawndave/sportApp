package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.*;
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
@RequestMapping("/athlete")
@RequiredArgsConstructor
public class AthleteController {

    private final CoachService coachService;
    private final AthleteService athleteService;
    private final ActivityService activityService;
    private final UserService userService;

    @GetMapping("/{username}")
    public String index(
            @PathVariable("username") String username, Model model){
        Athlete athlete = athleteService.getAthleteByUsername(username);
        athlete.setActivitiesWithOutCoach(activityService.getActivitiesWithoutCoach(athlete.getId()));
        model.addAttribute("athlete", athlete);
        return "users/athlete/info";
    }

    @GetMapping("/{username}/training-journal/{id}")
    public String getTrainingJournal(
            @PathVariable("username") String username,
            @PathVariable("id") Long id,
            Model model){
        AthleteWithCoach athlete = athleteService.getTrainingJournal(id);
        model.addAttribute("athlete", athlete);
        return "users/athlete/training/training-journal";
    }
    @GetMapping("/{username}/training-journal")
    public String getTrainingJournalAlltrainings(
            @PathVariable("username") String username,
            Model model){
        Athlete athlete = athleteService.getAthleteByUsername(username);
        model.addAttribute("athlete", athlete);
        return "users/athlete/training/training-journal-all";
    }


    @GetMapping("/{username}/add-activity")
    public String addTraining(
            @PathVariable("username") String username,
            Model model ){
        Athlete athlete = athleteService.getAthleteByUsername(username);
        List<Sport> activities = activityService.getActivities();
        model.addAttribute("activities", activities);
        model.addAttribute("athlete", athlete);
        return "users/athlete/add-activity";
    }

    @GetMapping("/{username}/add-activity/{activityId}")
    public String addTraining(
            @PathVariable("username") String username,
            @PathVariable("activityId") Long activityId,
                              Model model){
        activityService.addAthleteToSport(username, activityId);
        return "redirect:/athlete/" + username;
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        Coach coach = coachService.getCoachById(id);
        model.addAttribute("coach", coach);
        return "users/coach/edit";
    }

    @PostMapping("edit/{id}")
    public String doEditUser(@PathVariable("id") Long id, User user, Model model){
        Coach coach = coachService.getCoachById(id);
        return "redirect:/coach/" + coach.getUsername();
    }
}
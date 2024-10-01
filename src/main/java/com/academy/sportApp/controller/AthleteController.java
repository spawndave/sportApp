package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.service.AthleteService;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/athlete")
@RequiredArgsConstructor
public class AthleteController {

    private final CoachService coachService;
    private final UserService  userService;
    private final TrainingService trainingService;
    private final AthleteService athleteService;

    @GetMapping("/{username}")
    public String index(@PathVariable("username") String username, Model model){
        Athlete athlete = athleteService.getAthleteByUsername(username);
        model.addAttribute("athlete", athlete);
        return "users/athlete/info";
    }

    @GetMapping("/{username}/add_athlete")
    public String addAthlete(@PathVariable("username") String username, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        List<Athlete> athleteData = athleteService.getAthletesBySportWithoutCoach(coach.getSport().getId());
        model.addAttribute("athletes", athleteData);
        model.addAttribute("coach", coach);
        return "users/coach/add-athlete";
    }

    @GetMapping("/{username}/add_athlete/{id}")
    public String addAthlete(@PathVariable("username") String username,@PathVariable("id") Long id, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        AthleteWithCoach athlete = new AthleteWithCoach();
        athlete.setAthleteId(id);
        athlete.setCoachId(coach.getId());
        athlete.setSportId(coach.getSport().getId());
        coachService.saveAthlete(athlete);
        coach.getAthletes().add(athlete);
        model.addAttribute("user", coach);
        return "redirect:/coach/" + coach.getUsername();
    }

    @GetMapping("/{username}/add_training")
    public String addTraining(@PathVariable("username") String username, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        model.addAttribute("coach", coach);
        model.addAttribute("training", new Training());
        return "users/coach/add-training";
    }

    @PostMapping("/{username}/add_training")
    public String addTraining(@PathVariable("username") String username, Model model, Training training){
        Coach coach = coachService.getCoachByUsername(username);
        coach.getTrainings().add(training);
        training.setSportId(coach.getSport().getId());
        training.setCoachId(coach.getId());
        coachService.save(coach);
        model.addAttribute("coach", coach);
        return "redirect:/coach/" + coach.getUsername();
    }
    @GetMapping("/{username}/add_participant/{training_id}")
    public String getListCoachAthletesNotInTraining(
            @PathVariable("username") String username,
            @PathVariable("training_id") Long trainingId,
            Model model
            ){

        Coach coach = coachService.getCoachByUsername(username);
        Training training  = coachService.getCoachTrainingById( trainingId, coach );
        Set<AthleteWithCoach> athletes = coachService.getAllCoachAthletesNotInTraining(training);

        //coachService.addTrainingPatricipant(training, athleteId);
        //coachService.save(coach);
        model.addAttribute("coach", coach);
        model.addAttribute("training", training);
        model.addAttribute("athletes", athletes);
        return "users/coach/add_participant";
    }

    @GetMapping("/{username}/add_participant/{trainingId}/{athleteId}")
    public String addParticipantForTraining(
            @PathVariable("username") String username,
            @PathVariable("trainingId") Long trainingId,
            @PathVariable("athleteId") Long athleteId,
            Model model
    ){
        Coach coach = coachService.getCoachByUsername(username);
        trainingService.addParticipantToTraining(trainingId, athleteId, coach.getId());
        model.addAttribute("coach", coach);
        return "redirect:/coach/" + coach.getUsername();
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
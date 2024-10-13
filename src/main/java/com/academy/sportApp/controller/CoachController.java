package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.*;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import com.academy.sportApp.service.UserService;
import com.academy.sportApp.service.impl.AthleteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;
    private final UserService  userService;
    private final TrainingService trainingService;
    private final AthleteServiceImpl athleteService;

    @GetMapping("/{username}")
    public String index(
            @AuthenticationPrincipal User loggedInUser,
            @PathVariable("username") String username, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        model.addAttribute("coach", coach);
        return "users/coach/info";
    }
    @GetMapping("/{username}/training-journal")
    public String getTrainingList(
            @PathVariable("username") String username, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        model.addAttribute("coach", coach);
        return "users/coach/training-journal";
    }

    @GetMapping("/{username}/add_athlete")
    public String addAthlete(
            @PathVariable("username") String username, Model model){
        Coach coach = coachService.getCoachByUsername(username);
        List<Athlete> athleteData = athleteService.getAthletesBySportWithoutCoach(coach.getSport().getId());
        model.addAttribute("athletes", athleteData);
        model.addAttribute("coach", coach);
        return "users/coach/add-athlete";
    }

    @GetMapping("/{username}/add_athlete/{id}")
    public String addAthlete(
            @PathVariable("username") String username,
            @PathVariable("id") Long id,
            Model model){
        Coach coach = coachService.getCoachByUsername(username);
        AthleteWithCoach athlete = new AthleteWithCoach();
        Athlete athleteData = athleteService.getAthleteById(id);
        athlete.setCoach(coach);
        athlete.setAthleteData(athleteData);
        athlete.setSport(coach.getSport());
        coachService.saveAthlete(athlete);
        coach.getAthletes().add(athlete);
        model.addAttribute("user", coach);
        return "redirect:/coach/" + coach.getUsername();
    }

    @GetMapping("/{username}/add_training")
    public String addTraining(
            @PathVariable("username") String username,
            Model model){
        Coach coach = coachService.getCoachByUsername(username);
        model.addAttribute("coach", coach);
        model.addAttribute("training", new Training());
        return "users/coach/add-training";
    }

    @PostMapping("/{username}/add_training")
    public String addTraining(
            @PathVariable("username") String username,
            Model model, Training training){
        Coach coach = coachService.getCoachByUsername(username);
        coach.getTrainings().add(training);
        training.setSport(coach.getSport());
        training.setCoach(coach);
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
        trainingService.addParticipantToTraining(trainingId, athleteId, coach);
        model.addAttribute("coach", coach);
        return "redirect:/coach/" + coach.getUsername();
    }

    @GetMapping("/{username}/remove_participant/{trainingId}")
    public String getParticipantsList(
            @PathVariable("trainingId") Long trainingId,
            @PathVariable("username") String username,
            Model model){
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);
        return "training/remove_participant";
    }

    @GetMapping("/remove_participant/{trainingId}/{participantId}")
    public String getParticipantsList(
            @PathVariable("trainingId") Long trainingId,
            @PathVariable("participantId") Long participantId,
            Model model){
        trainingService.removeParticipantFromTraining(trainingId, participantId);
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);
        return "redirect:/coach/" + training.getCoach().getUsername();
    }

}
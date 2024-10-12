package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.Training;
import com.academy.sportApp.model.entity.TrainingParticipant;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.service.AthleteService;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import com.academy.sportApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/training")
@AllArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    private final CoachService coachService;
    private final AthleteService athleteService;
    private final UserService userService;


    @GetMapping("/{id}")
    public String index(
            @AuthenticationPrincipal User currUser,
            @PathVariable("id") Long id, Model model){
        Training training = trainingService.getTrainingById(id);
        Boolean isParticipant = trainingService.isCurrUserTrainingParticipant(training,currUser.getId());
        model.addAttribute("training", training);
        model.addAttribute("isParticipant", isParticipant);
        return "training/info";
    }


    @GetMapping("/edit-training/{id}")
    public String editTraining(@PathVariable("id")Long id, Model model){
        Training training = trainingService.getTrainingById(id);
        model.addAttribute("training", training);
        return "training/edit-training";
    }

    @PostMapping("/edit-training")
    public String saveTraining(Training training, Model model){
        trainingService.updateTraining(training);
        model.addAttribute("training", training);
        return "redirect:training/" + training.getId();
    }

    @GetMapping("/training-details/{participantId}")
    public String trainingDetails(
            @PathVariable("participantId") Long participantId,
            Model model){
        TrainingParticipant athlete = athleteService.getTrainingParticipant(participantId);
        model.addAttribute("athlete", athlete);
        return "users/athlete/training/info";
    }

    @PostMapping("/update-training-session/{id}")
    public String updateTrainingSession(
            @PathVariable("id") String participantId,
            TrainingParticipant participant, Model model){
        trainingService.updateTrainingData(participant, Long.valueOf(participantId));
        return "redirect:/training/training-details/" + participantId;
    }



}
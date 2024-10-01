package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.Training;
import com.academy.sportApp.service.CoachService;
import com.academy.sportApp.service.TrainingService;
import com.academy.sportApp.service.UserService;
import com.academy.sportApp.service.impl.AthleteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final CoachService coachService;
    private final UserService  userService;
    private final TrainingService trainingService;
    private final AthleteServiceImpl athleteService;

    @GetMapping("/{id}")
    public String index(@PathVariable("id") Long id, Model model){
        Training training = trainingService.getTraningById(id);
        model.addAttribute("training", training);
        return "training/info";
    }

    @GetMapping("/remove_participant/{trainingId}")
    public String getParticipantsList(@PathVariable("trainingId") Long trainingId, Model model){
        Training training = trainingService.getTraningById(trainingId);
        model.addAttribute("training", training);
        return "training/remove_participant";
    }

    @GetMapping("/remove_participant/{trainingId}/{participantId}")
    public String getParticipantsList(@PathVariable("trainingId") Long trainingId,
                                      @PathVariable("participantId") Long participantId,
                                      Model model){
        Training training = trainingService.getTraningById(trainingId);
        trainingService.removeParticipantFromTraining(training, participantId);
        model.addAttribute("training", training);
        return "redirect: training/" + trainingId;
    }

    @GetMapping("edit-training/{id}")
    public String editTraining(@PathVariable("id")Long id, Model model){
        Training training = trainingService.getTraningById(id);
        model.addAttribute("training", training);
        return "training/edit-training";
    }
    @PostMapping("edit")
    public String saveTraining(Training training, Model model){
        training = trainingService.updateTraining(training);
        model.addAttribute("training", training);
        return "training/edit-training";
    }



}
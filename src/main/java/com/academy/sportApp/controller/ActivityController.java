package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sport")
@AllArgsConstructor

public class ActivityController {
    private final UserService userService;
    private final ActivityService activityService;


    @GetMapping
    public String index(Model model){
        List<Sport> activities = activityService.getActivities();
        model.addAttribute("activities", activities);
        return "activity/list";
    }

    @GetMapping("/{sportName}")
    public String getActivityDescription(
            @PathVariable("sportName") String sportName,
            Model model){
        Sport activity = activityService.getSportByName(sportName);
        model.addAttribute("activity", activity);
        return "activity/info";
    }
}
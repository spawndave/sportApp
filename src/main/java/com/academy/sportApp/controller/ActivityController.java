package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final UserService userService;
    private final ActivityService activityService;


    @GetMapping
    public String index(Model model){
        List<Sport> activities = activityService.getActivities();
        model.addAttribute("activities", activities);
        return "activity/list";
    }
}
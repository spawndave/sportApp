package com.academy.sportApp.controller;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {
    private final UserService userService;
    private final ActivityService activityService;

    @GetMapping
    public String root() {
        return "redirect:/users"; // <.>
    }

    @GetMapping("/registration")
    public String registrationUser(Model model){
        model.addAttribute("roles", userService.getRoles());
        model.addAttribute("activities", activityService.getActivities());
        model.addAttribute("user", new NewUserDto());
        return "users/registration";
    }


    @PostMapping("/registration")
    public String registrationAthlete(
            @Valid @ModelAttribute("user") NewUserDto userDto,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", userService.getRoles());
            model.addAttribute("activities", activityService.getActivities());
            model.addAttribute("user", userDto);
            return "users/registration";
        }
        userService.saveUser(userDto);
        return "redirect:/users";
    }




}
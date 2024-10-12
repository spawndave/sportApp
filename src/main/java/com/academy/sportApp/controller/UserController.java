package com.academy.sportApp.controller;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.service.ActivityService;
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



    @GetMapping
    public String index(Model model){
        List<UserDto> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/athlete/{id}")
    public String showAthleteData(
            @PathVariable("id") Long id, Model model){
        UserDto user = userService.getUserDtoById(id);
        model.addAttribute("user", user);
        return "users/athlete/info";
    }


    @GetMapping("/registration")
    public String registrationUser(Model model){
        model.addAttribute("roles", userService.getRoles());
        model.addAttribute("activities", activityService.getActivities());
        model.addAttribute("user", new NewUserDto());
        return "users/edit";
    }


    @PostMapping("/registration")
    public String registrationAthlete( NewUserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/users";
    }



}
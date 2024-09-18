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
        //model.addAttribute("users", users);
        return "users/list";
    }
    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("editMode", "UPDATE");
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String doEditUser(@PathVariable("id") Long id, User user, Model model){
        //User user = userService.getUserById(id);
        User user2 = (User) model.getAttribute("user");
        userService.saveUser(user2);
        return "redirect:/users";
    }

    @GetMapping("/registration")
    public String registrationUser(Model model){
        model.addAttribute("user", new User());
        return "users/edit";
    }


    @PostMapping("/registration")
    public String registration( User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }





}
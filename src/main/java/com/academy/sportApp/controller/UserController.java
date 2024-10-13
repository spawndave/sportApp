package com.academy.sportApp.controller;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.service.ActivityService;
import com.academy.sportApp.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "users/registration";
    }


    @PostMapping("/registration")
    public String registrationAthlete(
            @NotNull
            @Valid @ModelAttribute("user") NewUserDto formData,
            BindingResult bindingResult,
             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("firstname", "asadasdasd");
            model.addAttribute("roles", userService.getRoles());
            model.addAttribute("activities", activityService.getActivities());
            model.addAttribute("user", formData);
            return "users/registration";
        }
        userService.saveUser(formData);
        return "redirect:/users";
    }

    @GetMapping("/edit/{username}")
    public String editUser(
            @AuthenticationPrincipal User loggedInUser,
            @PathVariable("username") String username, Model model){
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("edit/{username}")
    public String doEditUser(
            @PathVariable("username") String username,
            User user, Model model){
        userService.updateUserData(user, username);
        return "redirect:/users/";
    }


}
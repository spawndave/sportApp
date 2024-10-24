package com.academy.sportApp.controller;

import com.academy.sportApp.dto.UserDto;
import com.academy.sportApp.exceptions.UserWithEmailNotUniqException;
import com.academy.sportApp.model.entity.User;
import com.academy.sportApp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;



    @GetMapping
    public String index(
        @SortDefault.SortDefaults({
                    @SortDefault("firstName")}) Pageable pageable,
        @RequestParam(defaultValue = "sort") String sort,
        Model model) {
        Page<UserDto> users = userService.getUsers(pageable);
        model.addAttribute("users", users);
        model.addAttribute("sortBy", sort);
        return "users/list";
    }

    @GetMapping("/athlete/{id}")
    public String showAthleteData(
            @PathVariable("id") Long id, Model model){
        UserDto user = userService.getUserDtoById(id);
        model.addAttribute("user", user);
        return "users/athlete/info";
    }

    @GetMapping("/edit/{username}")
    public String editUser(
            @AuthenticationPrincipal User loggedInUser,
            @PathVariable("username") String username,
            Model model){
        UserDto userDto = userService.getUserDtoByUsername(username);
        model.addAttribute("user", userDto);
        return "users/edit";
    }

    @PostMapping("edit/{username}")
    public String doEditUser(
            @AuthenticationPrincipal User loggedInUser,
            @PathVariable("username") String username,
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult bindingResult,
            Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "users/edit";
        }
        try{
            userService.updateUserData(userDto, loggedInUser.getUsername());
        }catch(UserWithEmailNotUniqException exception){
            bindingResult.rejectValue("username", "error", "This username is already exist.");
        }
        return "redirect:/users";
    }


}
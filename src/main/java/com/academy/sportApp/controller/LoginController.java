package com.academy.sportApp.controller;

import com.academy.sportApp.model.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(
            @AuthenticationPrincipal User userDetails) {
        if (userDetails == null) {
            return "users/login";
        } else {
            return "redirect:/";
        }
    }


}
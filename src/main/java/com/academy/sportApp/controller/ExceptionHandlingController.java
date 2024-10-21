package com.academy.sportApp.controller;

import com.academy.sportApp.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userByIdNotFound(HttpServletRequest req, Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User with this username is not found")
    @ExceptionHandler(UserWithUsernameNotUniqException.class)
    public String userByUsernameNotFound(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,  reason="Training participant is not found")
    @ExceptionHandler(ParticipantNotFoundException.class)
    public String trainingParticipant(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,  reason="Training is not found")
    @ExceptionHandler(TrainingNotFoundException.class)
    public String trainingNotFound(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,  reason="User is not found")
    @ExceptionHandler(NoSuchElementException.class)
    public String userNotFound(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ExceptionHandler(TrainingSessionNotFoundException.class)
    public String databaseError(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "/error/info";
    }

}
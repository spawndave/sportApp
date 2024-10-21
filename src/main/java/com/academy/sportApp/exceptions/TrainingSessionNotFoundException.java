package com.academy.sportApp.exceptions;


public class TrainingSessionNotFoundException extends RuntimeException {
    public TrainingSessionNotFoundException(String message) {
        super(message);
    }

}
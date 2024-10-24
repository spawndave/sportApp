package com.academy.sportApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserWithEmailNotUniqException extends RuntimeException {

    public UserWithEmailNotUniqException(String username) {
        super(String.format("User with this email %s is already registered", username));
    }

}
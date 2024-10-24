package com.academy.sportApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserWithUsernameNotUniqException extends RuntimeException {

    public UserWithUsernameNotUniqException(String username) {
        super(String.format("User with this username %s is not found", username));
    }

}
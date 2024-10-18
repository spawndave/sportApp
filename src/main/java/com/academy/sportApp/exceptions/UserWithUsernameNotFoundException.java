package com.academy.sportApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserWithUsernameNotFoundException extends RuntimeException {

    public UserWithUsernameNotFoundException(String username) {
        super(String.format("User with this username %s is not found", username));
    }

}
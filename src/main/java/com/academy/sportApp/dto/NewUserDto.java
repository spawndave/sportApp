package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.Sport;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class NewUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private String dateOfBirth;
    private Role role;
    private Sport sport;
}
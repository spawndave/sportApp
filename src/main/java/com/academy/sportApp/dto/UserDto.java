package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class UserDto{
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private LocalDate dateOfBirth;
    private Role role;
}
package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.validators.NotExistingUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NotExistingUser
public class NewUserDto {
    @NotBlank(message = "Username shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}")
    private String username;

    @NotBlank(message = "password contain only letters and numbers, and it must be between 4 and 12 characters long")
    @Pattern(regexp = "[0-9A-Za-z]{4,12}")
    private String password;

    @NotBlank(message = "username contain only letters and numbers, and it must be between 4 and 16 characters long")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}")
    private String firstName;

    @NotBlank(message = "username contain only letters and numbers, and it must be between 4 and 16 characters long")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}")
    private String lastName;

    @NotBlank(message = "email isn't correct")
    @Pattern(regexp = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
    private String email;

    @NotNull(message = "incorrect date of birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull(message = "please choose the role")
    private Role role;

    @NotNull(message = "please select activity")
    private Sport sport;
}
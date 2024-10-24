package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.Sport;
import com.academy.sportApp.validators.NotUniqUsernameAndEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NotUniqUsernameAndEmail
public class NewUserDto {


    @NotBlank(message = "Username shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}", message="first name contain only letters and numbers, and it must be between 4 and 16 characters long")
    private String username;

    @NotBlank(message = "Password shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{4,12}", message = "password contain only letters and numbers, and it must be between 4 and 12 characters long")
    private String password;

    @NotBlank(message = "firstName shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{2,16}" ,message = "First name contain only letters and numbers, and it must be between 2 and 16 characters long")
    private String firstName;

    @NotBlank(message = "lastName shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{2,16}", message = "lastName contain only letters and numbers, and it must be between 2 and 16 characters long")
    private String lastName;

    @NotBlank(message = "email shouldn't be empty")
    @Pattern(regexp = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$", message = "email isn't correct")
    private String email;

    @NotNull(message = "incorrect date of birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull(message = "please choose the role")
    private Role role;

    @NotNull(message = "please select activity")
    private Sport sport;
}
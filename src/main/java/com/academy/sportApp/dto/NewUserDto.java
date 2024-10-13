package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import com.academy.sportApp.model.entity.Sport;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor

public class NewUserDto {
    @NotBlank
    @Size(min=2, max=30)
    private String username;

    @NotBlank
    @Size(min=4, max=12)
    private String password;

    @NotBlank
    @Size(min=4, max=30)
    private String firstName;

    @NotBlank
    @Size(min=4, max=30)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull
    private Role role;
    @NotNull
    private Sport sport;
}
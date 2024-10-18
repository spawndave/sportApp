package com.academy.sportApp.dto;

import com.academy.sportApp.model.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class UserDto{
    private Long id;

    @NotBlank(message = "Username shouldn't be empty")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}")
    private String username;

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

    private Role role;
}
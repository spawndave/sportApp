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
    @Pattern(regexp = "[0-9A-Za-z]{4,16}", message="first name contain only letters and numbers, and it must be between 4 and 16 characters long")
    private String username;

    @NotBlank(message = "email can't be blank")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}",message="first name contain only letters and numbers, and it must be between 4 and 16 characters long")
    private String firstName;

    @NotBlank(message = "email can't be blank")
    @Pattern(regexp = "[0-9A-Za-z]{4,16}",message="username contain only letters and numbers, and it must be between 4 and 16 characters long")
    private String lastName;


    @NotBlank(message = "email can't be blank")
    @Pattern(regexp = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",message="email isn't correct")
    private String email;

    @NotNull(message = "incorrect date of birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private Role role;
}
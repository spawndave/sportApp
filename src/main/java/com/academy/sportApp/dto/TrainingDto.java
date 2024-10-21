package com.academy.sportApp.dto;

import com.academy.sportApp.validators.NotCorrectTrainingDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NotCorrectTrainingDate
public class TrainingDto {
    @NotBlank(message = "Type the name of training")
    private String name;

    @NotBlank(message = "Describe exercises")
    private String description;

    @NotBlank(message = "Choose the location")
    private String location;

    @NotNull(message = "incorrect date ")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

}
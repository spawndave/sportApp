package com.academy.sportApp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TrainingDto {
    private Long trainingId;
    private Long athleteId;
}
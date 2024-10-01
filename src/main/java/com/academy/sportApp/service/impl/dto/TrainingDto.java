package com.academy.sportApp.service.impl.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TrainingDto {
    private Long trainingId;
    private Long athleteId;
}
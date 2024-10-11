package com.academy.sportApp.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrainingDifficulty {
    DEFAULT(0, "Please select"),
    EASY(1, "Easy"),
    NORMAL(2, "Normal"),
    HARD(3, "Hard");
    private  Integer value;
    private  String description;

}
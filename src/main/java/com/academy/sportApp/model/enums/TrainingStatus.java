package com.academy.sportApp.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrainingStatus {
    NOT_COMPLETED(1, "Not started"),
    COMPLETED(2, "Completed"),
    DELAYED(3, "Delayed");
    private  Integer value;
    private  String description;

}
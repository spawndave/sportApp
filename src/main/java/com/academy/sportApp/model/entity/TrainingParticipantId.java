package com.academy.sportApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TrainingParticipantId implements Serializable {

    @Column(name="coach_id")
    private Long coachId;

    @Column(name="athlete_id")
    private Long sportId;
}
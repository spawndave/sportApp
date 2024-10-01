package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "training_session")
public class TrainingSession extends ModifierOptions{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="athlete_id")
    private Long athleteId;

    @Column(name="training_id")
    private Long trainingId;

    @ManyToOne
    @JoinColumn(name = "training_id", updatable = false, insertable = false)
    private Training training;

    private Integer duration;

    @Column(name = "session_date")
    private LocalDate sessionDate;

    @Column(name = "difficulty_level")
    private int difficultyLevel;

    @Column(length = 1000)
    private String comments;

    public TrainingSession(Long trainingId, Long athleteId) {
        this.athleteId = athleteId;
        this.trainingId = trainingId;
    }
}
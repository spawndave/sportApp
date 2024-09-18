package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "training_session")
public class TrainingSession extends ModifierOptions{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;


    @Column(nullable = false)
    private Integer duration;

    @Column(name = "session_date")
    private LocalDate sessionDate;

    @Column(name = "difficulty_level", nullable = false)
    private int difficultyLevel;

    @Column(length = 1000)
    private String comments;

}
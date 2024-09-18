package com.academy.sportApp.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data

public class Training extends ModifierOptions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String location;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    @JsonBackReference
    private Coach coach;

    @OneToMany
    @JoinTable(
            name = "training_participant",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private List<TrainingParticipant> participants;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
}
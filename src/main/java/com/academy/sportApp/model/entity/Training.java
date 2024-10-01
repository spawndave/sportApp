package com.academy.sportApp.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Training extends ModifierOptions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String location;

    @Column(name = "coach_id")
    private Long coachId;

    @Column(name = "sport_id")
    private Long sportId;

    @ManyToOne
    @JoinColumn(name = "coach_id", updatable = false, insertable = false)
    @JsonBackReference
    private Coach coach;

    @OneToMany(mappedBy = "training")
    private Set<TrainingParticipant> participants;

    @ManyToOne
    @JoinColumn(name = "sport_id",  updatable = false, insertable = false)
    private Sport sport;
}
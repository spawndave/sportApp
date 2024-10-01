package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "coach_athlete_sport")
public class AthleteWithCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coach_id")
    private Long coachId;
    @Column(name="athlete_id")
    private Long athleteId;

    @Column(name="sport_id")
    private Long sportId;

    @ManyToOne
    @JoinColumn(name = "athlete_id", updatable = false, insertable = false)
    private Athlete data;


    @OneToMany(mappedBy = "athlete")
    private List<TrainingParticipant> trainings;

    @ManyToOne
    @JoinColumn(name = "coach_id", insertable = false, updatable = false)
    private Coach coach;



}
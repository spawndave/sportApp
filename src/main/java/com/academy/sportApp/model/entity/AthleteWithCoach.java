package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coach_athlete_sport")
public class AthleteWithCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="sport_id")
    private Sport sport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athleteData;


    @OneToMany(mappedBy = "athlete",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<TrainingParticipant> trainings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;



}
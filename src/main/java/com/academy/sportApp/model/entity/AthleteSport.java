package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "athlete_sport")
public class AthleteSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="athlete_id")
    private Long athleteId;

    @Column(name="sport_id")
    private Long sportId;

}
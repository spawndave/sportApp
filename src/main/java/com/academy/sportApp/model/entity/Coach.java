package com.academy.sportApp.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "coach_sport")
public class Coach{

    @Id
    @Column(name="coach_id")
    private Long coachId;

    @OneToOne
    @JoinColumn(name="coach_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_id")
    private Sport sport;

    @OneToMany(mappedBy = "coach",  fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Training> trainings;

    @ManyToMany
    @JoinTable(
            name = "coach_athlete",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private List<Athlete> athletes;


}
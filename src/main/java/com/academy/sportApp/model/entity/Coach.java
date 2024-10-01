package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity

@RequiredArgsConstructor
//@Table(name = "coach_sport")
//@PrimaryKeyJoinColumn(name = "coach_id")
@DiscriminatorValue("2")
public class Coach extends User{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "coach_athlete_sport",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private Sport sport;

    @OneToMany(mappedBy = "coach",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Training> trainings;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(
            name = "coach_athlete_sport",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private Set<AthleteWithCoach> athletes;




}
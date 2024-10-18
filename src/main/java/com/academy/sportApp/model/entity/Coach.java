package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity

@RequiredArgsConstructor
@DiscriminatorValue("2")
public class Coach extends User{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "coach_sport",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private Sport sport;

    @OneToMany(mappedBy = "coach",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude private List<Training> trainings;


    @OneToMany(mappedBy = "coach",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @ToString.Exclude private Set<AthleteWithCoach> athletes;

    @OneToMany(mappedBy = "coach",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude private List<TrainingRequest> trainingRequests;


}
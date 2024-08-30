package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "2")
public class Coach extends User{

    @ManyToOne
    @JoinTable(
            name = "coach_sport",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private Sport sport;

    @ManyToMany
    @JoinTable(
            name = "coach_athlete",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private List<Athlete> athletes;
}

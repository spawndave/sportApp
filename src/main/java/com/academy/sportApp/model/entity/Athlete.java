package com.academy.sportApp.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
//@Table(name="athlete_sport")
//@PrimaryKeyJoinColumn(name="athlete_id")
@DiscriminatorValue("3")
public class Athlete extends User{

   /* @ManyToMany
    @JoinTable(
            name = "coach_athlete_sport",
            joinColumns = @JoinColumn(name = "athlete_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "id")
    )
    private List<Sport> sports;*/

    @OneToMany(mappedBy = "data")
    private List<AthleteWithCoach> athleteActivities;


}
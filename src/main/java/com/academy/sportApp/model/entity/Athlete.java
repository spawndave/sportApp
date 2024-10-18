package com.academy.sportApp.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter
@Getter
@Entity

@DiscriminatorValue("3")
public class Athlete extends User{


    @OneToMany(mappedBy = "athleteData")
    private Set<AthleteWithCoach> activitiesWithCoach;

    @OneToMany(mappedBy = "athleteData")
    private Set<AthleteSport> allActivities;

    @OneToMany(mappedBy = "athleteData")
    private List<TrainingRequest> trainingRequests;

    @Transient
    private List<Sport> activitiesWithOutCoach;




}
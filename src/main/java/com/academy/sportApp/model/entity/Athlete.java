package com.academy.sportApp.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name="athlete_sport")
public class Athlete{
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "athlete_id")
    private User user;

    @OneToMany(mappedBy = "athlete")
    @JsonManagedReference
    private List<TrainingParticipant> trainings;

}
package com.academy.sportApp.model.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;


@Setter
@Getter
@Entity

//@Table(name = "user")
//@Where(clause = "role_id = 3")
@DiscriminatorValue(value = "3")
public class Athlete extends User{
   /* @Id
    private Long id;*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "athlete_sport",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private List<Sport> sports;


    /*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "athletes")
    private List<Coach> coaches;*/

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<TrainingSession> trainingSessions ;
}

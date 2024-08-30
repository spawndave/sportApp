package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Sport extends ModifierOptions{
    @Id
    private Long id;
    private String name;
    private String description;
   /* @OneToMany
    @JoinTable(
            name = "coach",
            joinColumns = @JoinColumn(name = "sport_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private List<Coach> coaches;*/
}

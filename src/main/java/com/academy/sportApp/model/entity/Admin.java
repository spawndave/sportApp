package com.academy.sportApp.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
//@Table(name="athlete_sport")
//@PrimaryKeyJoinColumn(name="athlete_id")
@DiscriminatorValue("1")
public class Admin extends User{
}
package com.academy.sportApp.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity

@DiscriminatorValue("1")
public class Admin extends User{




}
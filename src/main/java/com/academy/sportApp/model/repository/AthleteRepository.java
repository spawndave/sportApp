package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
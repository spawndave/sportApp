package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    @Query("FROM AthleteSport  where sportId=:id  and athleteId not in " +
            "( select athleteId from AthleteWithCoach where sportId =: id) ")
    List<Athlete> getAthletesBySportIdNotIn(Long id);

}
package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    @Query("From Athlete where id  in(select athleteData.id FROM AthleteSport  where sport.id=:sportId and athleteData.id  not in " +
            "( select athleteData.id from AthleteWithCoach where sport.id =:sportId))")
    List<Athlete> getAthletesBySportWithoutCoach(Long sportId);
}
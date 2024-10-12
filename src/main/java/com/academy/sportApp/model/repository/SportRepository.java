package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {
    @Query("From Sport where id =(select sport.id FROM AthleteSport  where athleteData.id =:athleteId and sport.id   not in " +
            "( select sport.id from AthleteWithCoach where athleteData.id =:athleteId))")
    List<Sport> getActivitiesWithoutCoach(Long athleteId);
    Sport getSportByName(String sportName);

}
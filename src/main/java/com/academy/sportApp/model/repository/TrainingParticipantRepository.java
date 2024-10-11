package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.TrainingParticipant;
import com.academy.sportApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingParticipantRepository extends JpaRepository<TrainingParticipant, Long> {
    TrainingParticipant getTrainingParticipantById(Long id);
    void deleteById(Long id);
    List<TrainingParticipant> findTrainingParticipantByAthleteAndCoach(User athlete, User coach);
}
package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.TrainingParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingParticipantRepository extends JpaRepository<TrainingParticipant, Long> {
    TrainingParticipant getTrainingParticipantById(Long id);
    void deleteById(Long id);
}
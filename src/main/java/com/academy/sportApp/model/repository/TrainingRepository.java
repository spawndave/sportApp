package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training getTrainingByIdAndCoachId(Long id, Long coach_id);
}
package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.TrainingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRequestRepository extends JpaRepository<TrainingRequest, Long> {

}
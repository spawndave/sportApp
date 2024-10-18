package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.AthleteSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteSportRepository extends JpaRepository<AthleteSport, Long> {

}
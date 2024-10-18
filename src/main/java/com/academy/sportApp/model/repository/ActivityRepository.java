package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Sport, Long> {

}
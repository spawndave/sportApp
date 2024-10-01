package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {


}
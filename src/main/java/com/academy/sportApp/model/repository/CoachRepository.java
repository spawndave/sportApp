package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Coach;
import com.academy.sportApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CoachRepository extends JpaRepository<Coach, Long> {

}

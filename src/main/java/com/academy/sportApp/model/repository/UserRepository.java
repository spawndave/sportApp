package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

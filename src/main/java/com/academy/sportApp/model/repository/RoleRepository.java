package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
package com.academy.sportApp.model.repository;

import com.academy.sportApp.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> getRolesByIdAfter(Long id);
}
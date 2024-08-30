package com.academy.sportApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class ModifierOptions {
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;
}

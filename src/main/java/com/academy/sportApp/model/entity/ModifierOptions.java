package com.academy.sportApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class ModifierOptions {
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "updated_at")
    private LocalDate updatedAt = LocalDate.now();
}
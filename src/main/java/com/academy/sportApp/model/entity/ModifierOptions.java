package com.academy.sportApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class ModifierOptions {
    @Column(name = "created_at")
    private String createdAt = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    @Column(name = "updated_at")
    private String updatedAt = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
}
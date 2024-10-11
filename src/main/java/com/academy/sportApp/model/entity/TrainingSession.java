package com.academy.sportApp.model.entity;

import com.academy.sportApp.model.enums.TrainingDifficulty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training_session")
public class TrainingSession extends ModifierOptions{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "athlete_id")
    private Athlete data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "session_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate sessionDate;

    @Column(name = "difficulty_level")
    @Enumerated(EnumType.STRING)
    private TrainingDifficulty difficulty = TrainingDifficulty.DEFAULT;

    private String comments;

}
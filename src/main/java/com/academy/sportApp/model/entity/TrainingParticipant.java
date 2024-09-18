package com.academy.sportApp.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "training_participant")
public class TrainingParticipant {
    @Id
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "training_session",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id")
    )
    private TrainingSession trainingSession;

}
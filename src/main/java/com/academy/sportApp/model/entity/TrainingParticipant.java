package com.academy.sportApp.model.entity;

import com.academy.sportApp.model.enums.TrainingStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training_participant")
public class TrainingParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "athlete_id")
    private Athlete athleteData;

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "athlete_id", referencedColumnName = "athlete_id",updatable = false, insertable = false),
                    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id", updatable = false, insertable = false)
            }
    )
    private AthleteWithCoach athlete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainingStatus status = TrainingStatus.NOT_COMPLETED;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    private Training training;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tr_session_id")
    private TrainingSession trainingSession;


}
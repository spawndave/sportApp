package com.academy.sportApp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "training_participant")
public class TrainingParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @EmbeddedId
    private TrainingParticipantId id;*/
    @Column(name = "training_id")
    private Long trainingId;

    @Column(name="coach_id")
    private Long coachId;

    @Column(name="athlete_id")
    private Long athleteId;

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "athlete_id", referencedColumnName = "athlete_id",updatable = false, insertable = false),
                    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id", updatable = false, insertable = false)
            }
    )
    private AthleteWithCoach athlete;

    @ManyToOne
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_session_id")
    private TrainingSession trainingSession = new TrainingSession();

    public TrainingParticipant() {

    }
}
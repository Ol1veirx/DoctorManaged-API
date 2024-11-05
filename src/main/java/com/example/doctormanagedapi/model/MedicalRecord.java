package com.example.doctormanagedapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;
    private String treatment;
    private String observations;
    private String docs;

    @OneToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}

package com.example.doctormanagedapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String medicalConditions;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;
}

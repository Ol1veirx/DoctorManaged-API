package com.example.doctormanagedapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String CRM;
    private String email;
    private String phone;
    private String speciality;
    private String password;

    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultations;
}

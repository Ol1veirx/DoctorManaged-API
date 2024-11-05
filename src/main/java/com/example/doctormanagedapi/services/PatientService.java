package com.example.doctormanagedapi.services;

import com.example.doctormanagedapi.model.Patient;
import com.example.doctormanagedapi.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        Patient existingPatient = patientRepository.findById(patient.getId()).orElseThrow();

        existingPatient.setName(patient.getName());
        existingPatient.setBirthDate(patient.getBirthDate());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setMedicalConditions(patient.getMedicalConditions());

        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patientRepository.deleteById(patient.getId());
    }
}

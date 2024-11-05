package com.example.doctormanagedapi.services;

import com.example.doctormanagedapi.model.Doctor;
import com.example.doctormanagedapi.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = doctorRepository.findById(doctor.getId()).orElseThrow();

        existingDoctor.setCRM(doctor.getCRM());
        existingDoctor.setName(doctor.getName());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setSpeciality(doctor.getSpeciality());

        return doctorRepository.save(existingDoctor);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();

        doctorRepository.deleteById(doctor.getId());
    }
}

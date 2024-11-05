package com.example.doctormanagedapi.services;

import com.example.doctormanagedapi.model.Consultation;
import com.example.doctormanagedapi.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation findByIdConsultation(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(Consultation consultation) {
        Consultation existingConsultation = consultationRepository.findById(consultation.getId()).orElse(null);

        if(existingConsultation == null) {
            throw new IllegalArgumentException("Consultation not found");
        }

        existingConsultation.setDate(consultation.getDate());
        existingConsultation.setDoctor(consultation.getDoctor());
        existingConsultation.setReasonConsultation(consultation.getReasonConsultation());
        existingConsultation.setPatient(consultation.getPatient());
        existingConsultation.setStatus(consultation.getStatus());

        return consultationRepository.save(existingConsultation);
    }

    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id).orElseThrow();

        consultationRepository.deleteById(consultation.getId());
    }
}

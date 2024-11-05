package com.example.doctormanagedapi.services;

import com.example.doctormanagedapi.model.MedicalRecord;
import com.example.doctormanagedapi.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id).orElseThrow();
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(medicalRecord.getId()).orElseThrow();

        existingMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
        existingMedicalRecord.setTreatment(medicalRecord.getTreatment());
        existingMedicalRecord.setObservations(medicalRecord.getObservations());
        existingMedicalRecord.setConsultation(medicalRecord.getConsultation());

        return medicalRecordRepository.save(existingMedicalRecord);
    }

    public void deleteMedicalRecord(Long id) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow();

        medicalRecordRepository.deleteById(medicalRecord.getId());
    }
}

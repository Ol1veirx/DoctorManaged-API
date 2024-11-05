package com.example.doctormanagedapi.repository;

import com.example.doctormanagedapi.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}

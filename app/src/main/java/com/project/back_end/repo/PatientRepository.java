package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Custom query to find a patient by their email or username
    Optional<Patient> findByEmail(String email);
    
    // Custom query to find a patient by name
    Optional<Patient> findByName(String name);
}
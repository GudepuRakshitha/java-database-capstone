package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Retrieve all doctors from the database
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    // Save or update a doctor record
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Find a specific doctor by their ID
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    // Find doctors by their specialty
    public List<Doctor> findBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }
}
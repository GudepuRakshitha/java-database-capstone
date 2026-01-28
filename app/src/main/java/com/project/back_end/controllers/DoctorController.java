package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GetMapping("/availability/{doctorId}")
public ResponseEntity<?> getAvailability(
        @PathVariable Long doctorId,
        @RequestParam String date,
        @RequestHeader("Authorization") String token) {

    if (!tokenService.validateToken(token)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid token");
    }

    return ResponseEntity.ok(
        doctorService.getAvailableSlots(doctorId, LocalDate.parse(date))
    );
}

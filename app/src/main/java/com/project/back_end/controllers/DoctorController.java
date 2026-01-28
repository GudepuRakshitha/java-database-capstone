package com.project.back_end.controllers;

import com.project.back_end.services.DoctorService;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TokenService tokenService;

    // GET doctor availability by date
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
}

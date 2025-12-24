package com.project.hospitalMangement.repository;

import com.project.hospitalMangement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
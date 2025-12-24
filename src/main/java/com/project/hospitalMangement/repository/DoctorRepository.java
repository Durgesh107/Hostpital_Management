package com.project.hospitalMangement.repository;

import com.project.hospitalMangement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
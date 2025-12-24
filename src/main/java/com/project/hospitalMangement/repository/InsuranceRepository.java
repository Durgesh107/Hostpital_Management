package com.project.hospitalMangement.repository;

import com.project.hospitalMangement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
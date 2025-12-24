package com.project.hospitalMangement.repository;

import com.project.hospitalMangement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
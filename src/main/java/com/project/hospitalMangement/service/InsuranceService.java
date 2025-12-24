package com.project.hospitalMangement.service;

import com.project.hospitalMangement.entity.Insurance;
import com.project.hospitalMangement.entity.Patient;
import com.project.hospitalMangement.repository.InsuranceRepository;
import com.project.hospitalMangement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient now found with id:" + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // for the bidirectional consistency maintance
        return patient;
    }
}

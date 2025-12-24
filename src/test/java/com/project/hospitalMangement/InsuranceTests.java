package com.project.hospitalMangement;


import com.project.hospitalMangement.entity.Insurance;
import com.project.hospitalMangement.entity.Patient;
import com.project.hospitalMangement.repository.InsuranceRepository;
import com.project.hospitalMangement.repository.PatientRepository;
import com.project.hospitalMangement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }
}

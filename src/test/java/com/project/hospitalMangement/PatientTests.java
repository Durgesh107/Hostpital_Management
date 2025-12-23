package com.project.hospitalMangement;

import com.project.hospitalMangement.entity.Patient;
import com.project.hospitalMangement.repository.PatientRepository;
import com.project.hospitalMangement.service.PatientService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patients=patientRepository.findAll();
        System.out.println(patients);
    }

    @Test
    public void testTransactionMethods(){
        Patient patient=patientService.getPatientById(2L);
        System.out.println(patient);
    }
}

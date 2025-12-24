package com.project.hospitalMangement.service;

import com.project.hospitalMangement.entity.Appointment;
import com.project.hospitalMangement.entity.Doctor;
import com.project.hospitalMangement.entity.Patient;
import com.project.hospitalMangement.repository.AppointmentRepository;
import com.project.hospitalMangement.repository.DoctorRepository;
import com.project.hospitalMangement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) {
            throw new IllegalArgumentException("Appointment should not have a valid ID when creating a new entry");
        }
         appointment.setPatient(patient);
         appointment.setDoctor(doctor);

         patient.getAppointments().add(appointment); // to maintain consistency

         return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        return appointment;

    }
}

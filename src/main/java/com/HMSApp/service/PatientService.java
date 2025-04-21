package com.HMSApp.service;

import com.HMSApp.dto.PatientDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    PatientDto createPatient(PatientDto patientDto);

    List<PatientDto> getAllPatients();

     void deletePatient(Long id);

    PatientDto updatePatient(Long id, PatientDto patientDto);

     PatientDto getPatientById(Long id);
}

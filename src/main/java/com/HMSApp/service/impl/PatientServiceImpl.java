package com.HMSApp.service.impl;

import com.HMSApp.dto.PatientDto;
import com.HMSApp.entity.Patient;
import com.HMSApp.repository.PatientRepository;
import com.HMSApp.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private ModelMapper modelMapper;



    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        PatientDto savedPatientDto = mapToDto(savedPatient);
        return savedPatientDto;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDto = patients.stream().map(this::mapToDto).collect(Collectors.toList());

        return patientDto;
    }

    @Override
    public void deletePatient(Long id) {
        Optional<Patient> byId = patientRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Patient not found with id : " + id);
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isEmpty()){
            throw new RuntimeException("Patient not found with id : " + id);
        }
        Patient existingPatient = patient.get();
        existingPatient.setName(patientDto.getName());
        existingPatient.setAge(patientDto.getAge());
        existingPatient.setBlood(patientDto.getBlood());
        existingPatient.setPrescription(patientDto.getPrescription());
        existingPatient.setDose(patientDto.getDose());
        existingPatient.setFees(patientDto.getFees());
        existingPatient.setUrgency(patientDto.getUrgency());
        Patient updatedPatient = patientRepository.save(existingPatient);
        PatientDto patientDto1 = mapToDto(updatedPatient);

        return patientDto1;
    }

    @Override
    public PatientDto getPatientById(Long id) {

        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isEmpty()){
            throw new RuntimeException("Patient not found with id :" + id);
        }
        PatientDto patientDto = mapToDto(patient.get());
        return patientDto;
    }


    // ModelMapper


    Patient  mapToEntity(PatientDto patientDto) {
        Patient mapToEntity = modelMapper.map(patientDto, Patient.class);
        return mapToEntity;
    }

    PatientDto  mapToDto(Patient patient) {
        PatientDto mapToDto = modelMapper.map(patient, PatientDto.class);
        return mapToDto;
    }
}

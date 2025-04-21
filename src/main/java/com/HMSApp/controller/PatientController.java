package com.HMSApp.controller;

import com.HMSApp.dto.PatientDto;
import com.HMSApp.service.PatientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping("/createPatient")
    public ResponseEntity<PatientDto> creatPatientDto(@RequestBody PatientDto patientDto){
        PatientDto patient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }


    @GetMapping

    public ResponseEntity<List<PatientDto>> getPatientAll(){
        List<PatientDto> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }


    @DeleteMapping("/{id}/patientDelete")

    public ResponseEntity<String> deletePatientById(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted successfully!", HttpStatus.OK);
    }


    @PutMapping("/{id}/updatePatient")
     public ResponseEntity<String> updatePatientById(
              @PathVariable Long id,
              @RequestBody PatientDto patientDto
              ) {
            patientService.updatePatient(id, patientDto);
            return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
          }



          @GetMapping("/{id}/getPatientById")

          public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
               PatientDto patient = patientService.getPatientById(id);
               return new ResponseEntity<>(patient, HttpStatus.OK);
          }


}

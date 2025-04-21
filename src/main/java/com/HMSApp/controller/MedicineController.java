package com.HMSApp.controller;


import com.HMSApp.dto.MedicineDto;
import com.HMSApp.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicines")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/createMedicine")

    public ResponseEntity<MedicineDto> createMedicine(@RequestBody MedicineDto medicineDto){
        MedicineDto medicine = medicineService.createMedicine(medicineDto);
        return  new ResponseEntity<>(medicine, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<MedicineDto>> getAlltMedicine(){
        List<MedicineDto> allMedicine = medicineService.getAllMedicine();
        return new ResponseEntity<>(allMedicine, HttpStatus.OK);
    }


    @GetMapping("/{id}/getMedicineById")
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id){
        MedicineDto medicineById = medicineService.getMedicineById(id);
        return new ResponseEntity<>(medicineById, HttpStatus.OK);
    }


    @DeleteMapping("/{id}/deleteMedicineById")

    public ResponseEntity<String> deletePatientById(@PathVariable Long id){
        medicineService.deleteMedicineById(id);
        return new ResponseEntity<>("Medicine deleted successfully!", HttpStatus.OK);
    }


    @PutMapping("/{id}/updateMedicineById")


    public ResponseEntity<?> updateMedicineById(
            @PathVariable long id,
            @RequestBody MedicineDto medicineDto
            ){
        medicineService.updateMedicineById(id,medicineDto);
        return new ResponseEntity<>("Medicine updated successfully!", HttpStatus.OK);
    }
}

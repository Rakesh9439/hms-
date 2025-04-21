package com.HMSApp.service;

import com.HMSApp.dto.MedicineDto;

import java.util.List;

public interface MedicineService {

    MedicineDto createMedicine(MedicineDto medicineDto);

    List<MedicineDto> getAllMedicine();

    MedicineDto getMedicineById(Long id);

    void deleteMedicineById(Long id);

    MedicineDto updateMedicineById(Long id, MedicineDto medicineDto);
}

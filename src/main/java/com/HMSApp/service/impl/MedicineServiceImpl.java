package com.HMSApp.service.impl;

import com.HMSApp.dto.MedicineDto;
import com.HMSApp.entity.Medicine;
import com.HMSApp.repository.MedicineRepository;
import com.HMSApp.service.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;
    private ModelMapper modelMapper;

    public MedicineServiceImpl(MedicineRepository medicineRepository, ModelMapper modelMapper) {
        this.medicineRepository = medicineRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MedicineDto createMedicine(MedicineDto medicineDto) {
        Medicine medicine = mapToEntity(medicineDto);
        Medicine savedMedicine = medicineRepository.save(medicine);
        MedicineDto medicineDto1 = mapToDto(savedMedicine);
        return medicineDto1;
    }

    @Override
    public List<MedicineDto> getAllMedicine() {

        List<Medicine> medicines = medicineRepository.findAll();
        List<MedicineDto> medicineDto = medicines.stream().map(this::mapToDto).collect(Collectors.toList());
        return medicineDto;
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isEmpty()){
            throw new RuntimeException("Medicine not found with id : " + id);
        }

        MedicineDto medicineDto = mapToDto(medicine.get());
        return medicineDto;
    }

    @Override
    public void deleteMedicineById(Long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isEmpty()){
            throw new RuntimeException("Medicine not found with id : " + id);
        }
        medicineRepository.deleteById(id);
    }

    @Override
    public MedicineDto updateMedicineById(Long id, MedicineDto medicineDto) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if (medicine.isEmpty()){
            throw new RuntimeException("Medicine not found with id : " + id);
        }
        Medicine existingMedicine = medicine.get();
        existingMedicine.setDrugName(medicineDto.getDrugName());
        existingMedicine.setStock(medicineDto.getStock());
        Medicine updatedMedicine = medicineRepository.save(existingMedicine);
        MedicineDto medicineDto1 = mapToDto(updatedMedicine);
        return medicineDto1;
    }


    //ModelMapper

    Medicine mapToEntity(MedicineDto medicineDto){
        return modelMapper.map(medicineDto, Medicine.class);
    }

    MedicineDto mapToDto(Medicine medicine){
        return modelMapper.map(medicine, MedicineDto.class);
    }
}

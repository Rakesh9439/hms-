package com.HMSApp.service.impl;

import com.HMSApp.dto.AppointmentDto;
import com.HMSApp.entity.Appointment;
import com.HMSApp.exception.ResourceNotFoundException;
import com.HMSApp.repository.AppointmentRepository;
import com.HMSApp.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private ModelMapper modelMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = matToEntity(appointmentDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        AppointmentDto appointmentDto1 = mapToDto(savedAppointment);
        return appointmentDto1;
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDto = appointments.stream().map(this::mapToDto).collect(Collectors.toList());
        return appointmentDto;
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Optional<Appointment> byId = appointmentRepository.findById(id);
        if(byId.isEmpty()){
            throw new ResourceNotFoundException("Appointment not found with id " + id);
        }

        AppointmentDto appointmentDto = mapToDto(byId.get());
        return appointmentDto;
    }

    @Override
    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto) {

        Optional<Appointment> existingAppointmentOpt = appointmentRepository.findById(id);
        if (existingAppointmentOpt.isEmpty()){
            throw new ResourceNotFoundException("Appointment not found with id " + id);
        }
        Appointment existingAppointment = existingAppointmentOpt.get();
        existingAppointment.setName(appointmentDto.getName());
        existingAppointment.setAge(appointmentDto.getAge());
        existingAppointment.setSymptoms(appointmentDto.getSymptoms());
        existingAppointment.setNumber(appointmentDto.getNumber());

        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);

        AppointmentDto appointmentDto1 = mapToDto(updatedAppointment);
        return appointmentDto1;
    }

    @Override
    public void deleteAppointment(Long id) {
        if(!appointmentRepository.existsById(id)){
            throw new ResourceNotFoundException("Appointment not found with id " + id);
        }
        appointmentRepository.deleteById(id);
    }


    //ModelMapper

    Appointment matToEntity(AppointmentDto appointmentDto) {
        Appointment mapToEntity = modelMapper.map(appointmentDto, Appointment.class);
        return mapToEntity;
    }

    AppointmentDto mapToDto(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDto.class);
    }

}

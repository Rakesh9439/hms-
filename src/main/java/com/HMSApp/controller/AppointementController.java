package com.HMSApp.controller;

import com.HMSApp.dto.AppointmentDto;
import com.HMSApp.service.AppointmentService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointementController {

    private AppointmentService appointmentService;

    public AppointementController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @PostMapping("/createAppointment")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto appointment = appointmentService.createAppointment(appointmentDto);
        return  new ResponseEntity<>(appointment, HttpStatus.CREATED);

    }

    @GetMapping

    public ResponseEntity<List<AppointmentDto>> getAllAppointments(){
        List<AppointmentDto> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
     public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {

        AppointmentDto appointment = appointmentService.getAppointmentById(id);
       return new ResponseEntity<>(appointment, HttpStatus.OK);
    }


    @PutMapping("/{id}/update")
     public ResponseEntity<String> updateAppointment(
              @PathVariable Long id,
              @RequestBody AppointmentDto appointmentDto ) {
       appointmentService.updateAppointment(id, appointmentDto);
        return new ResponseEntity<>("Appointment Updated succsessfully !", HttpStatus.OK);
    }


    @DeleteMapping("/{id}/appointmentDelete")
   public ResponseEntity<String> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointments deleted successfully", HttpStatus.OK);
   }



}

package com.HMSApp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private String name;

    private int age;
    private String blood;
    private String prescription;
    private String dose;
    private String fees;
    private String urgency;


}

package com.HMSApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDto {
    private Long id;
    private String name;
    private String age;
    private String symptoms;
    private String number;
}

package com.HMSApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)

    @Column(name = "full_name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "age", nullable = false)
    private String age;  // Consider changing to an `int` for better validation

    @NotBlank(message = "Symptoms are required")
    @Size(min = 5, max = 255, message = "Symptoms must be between 5 and 255 characters")
    @Column(name = "symptoms", nullable = false)
    private String symptoms;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    @Column(name = "contact_number", nullable = false, length = 10)
    private String number;
}

package com.HMSApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id") // Explicit column name
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "full_name", nullable = false) // Maps to full_name in the DB
    private String name;

    @Min(0)
    @Max(150)
    @Column(name = "age", nullable = false)
    private int age;

    @NotBlank
    @Column(name = "blood_group", nullable = false) // Maps to blood_group in the DB
    private String blood;

    @Column(name = "prescription_details")
    private String prescription;

    @Column(name = "dose_info")
    private String dose;

    @Positive
    @Column(name = "treatment_fees") // Maps to treatment_fees in the DB
    private String fees;

    @NotBlank
    @Column(name = "urgency_level", nullable = false) // Maps to urgency_level in the DB
    private String urgency;


}

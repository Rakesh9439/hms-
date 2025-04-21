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
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;

//    @NotNull
//    @Size(min = 2, max = 100)
    @Column(name = "drug_name", nullable = false)
    private String drugName;

//    @NotBlank
//    @Pattern(regexp = "^\\d+$", message = "Stock must be a number")
    @Column(name = "stock_quantity", nullable = false)
    private String stock;
}

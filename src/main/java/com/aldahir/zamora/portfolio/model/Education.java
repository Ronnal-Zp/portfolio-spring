package com.aldahir.zamora.portfolio.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    private Long id;

    @NotBlank(message = "El grado es requerido")
    private String degree;

    @NotBlank(message = "La institución es requerida")
    private String institution;

    @NotNull(message = "La fecha de inicio es requerida")
    @PastOrPresent(message = "La fecha de inicio no puede ser posterior a hoy")
    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    @NotNull(message = "El id de la persona es requerido")
    private Long personalInfoId;
}

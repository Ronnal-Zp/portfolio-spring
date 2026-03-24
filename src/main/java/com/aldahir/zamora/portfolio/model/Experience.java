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
public class Experience {
    private Long id;

    @NotBlank(message = "El titulo del trabajo es requerido")
    private String jobTitle;

    @NotBlank(message = "El nombre de la compañía es requerido")
    private String companyName;

    @NotNull(message = "La fecha de inicio es requerida")
    @PastOrPresent(message = "La fecha de inicio no puede ser posterior a hoy")
    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    @NotNull(message = "El id de la persona es requerido")
    private Long personalInfoId;
}

package com.aldahir.zamora.portfolio.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotNull(message = "El porcentaje es requerido")
    @Min(value = 0, message = "El porcentaje debe de ser mayor a 0")
    @Max(value = 100, message = "El procentaje no puede ser mayor a 100")
    private Integer levelPercentage;

    @NotBlank(message = "El icono es requerido")
    private String iconClass;
    private Long personalInfoId;
}

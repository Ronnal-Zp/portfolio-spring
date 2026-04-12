package com.aldahir.zamora.portfolio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillDto {
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotNull(message = "El porcentaje es requerido")
    @Min(value = 0, message = "El porcentaje debe de ser mayor a 0")
    @Max(value = 100, message = "El procentaje no puede ser mayor a 100")
    private Integer levelPercentage;

    @NotBlank(message = "El icono es requerido")
    private String iconClass;

    @NotNull(message = "El id de informacion personal es obligatorio.")
    @Min(value = 1, message = "El id de informacion personal no puede ser un numero negativo")
    private Long personalInfoId;
}

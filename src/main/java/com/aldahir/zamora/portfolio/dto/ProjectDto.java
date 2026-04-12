package com.aldahir.zamora.portfolio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    @NotBlank(message = "El titulo no puede estar en blanco")
    @Size(min = 2, max = 255, message = "El titulo debe tener entre 2 y 255 caracteres")
    private String title;

    @NotBlank(message = "La descripción no puede estar en blanco")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    private String description;

    @URL(message = "La url de la imagen no tiene un formato valido")
    private String imageUrl;

    @URL(message = "La url del proyecto no tiene un formato valido")
    private String projectUrl;

    @NotNull(message = "El id de informacion personal es obligatorio.")
    @Min(value = 1, message = "El id de informacion personal no puede ser un numero negativo")
    private Long personalInfoId;
}

package com.aldahir.zamora.portfolio.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;
    @NotBlank(message = "El titulo no puede estar en blanco")
    @Size(min = 2, max = 255, message = "El titulo debe tener entre 2 y 255 caracteres")
    private String title;
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Size(min = 10, max = 255, message = "La descripcion debe tener entre 10 y 255 caracteres")
    private String description;
    @URL(message = "No es un url valida")
    private String imageUrl;
    @URL(message = "No es un url valida")
    private String projectUrl;
    @NotNull(message = "El id de informacion personal no puede ser nulo")
    @Min(value = 1, message = "El id de informacion personal debe ser un numero positivo")
    private Long personalInfoId;
}

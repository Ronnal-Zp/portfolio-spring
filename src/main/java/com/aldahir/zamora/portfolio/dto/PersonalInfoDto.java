package com.aldahir.zamora.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonalInfoDto {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String firstName;
    @NotBlank(message = "El apellido no puede estar vacio")
    private String lastName;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;
    @Size(min=10, max=35, message = "Debe tener minio 10 caracteres y maximo 35 caracteres")
    private String profileDescription;
    private String profileImageUrl;
    @Min(value = 1, message = "Debe tener al menos 1 anio de experiencia")
    private Integer yearsOfExperience;
    @Email(message = "No es un email valido")
    private String email;
    @Size(min=10, max=10, message = "No es un numero telefonico valido")
    private String phone;

    private String linkedinUrl;
    private String githubUrl;
}

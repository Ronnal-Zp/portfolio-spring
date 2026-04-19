package com.aldahir.zamora.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "El nombre es requerido")
    private String username;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min=5, message = "La contraseña debe tener mínimo 5 caracteres")
    private String password;
}

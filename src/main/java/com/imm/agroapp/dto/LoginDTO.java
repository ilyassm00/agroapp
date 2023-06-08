package com.imm.agroapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {

    @NotBlank(message = "El nom d'usuari és obligatori")
    private String username;

    @NotBlank(message = "La contrasenya és obligatòria")
    private String password;
}

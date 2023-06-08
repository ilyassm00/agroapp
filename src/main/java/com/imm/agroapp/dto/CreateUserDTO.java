package com.imm.agroapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    @NotBlank(message = "El nom d'usuari és obligatori")
    private String username;

    @NotBlank(message = "L'email és obligatori")
    @Email(message = "L'email no és vàlid")
    private String email;

    @NotBlank(message = "La contrasenya és obligatòria")
    private String password;
}

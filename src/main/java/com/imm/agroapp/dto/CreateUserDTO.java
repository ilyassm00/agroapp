package com.imm.agroapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "email is mandatory")
    @Email(message = "email not valid")
    private String email;

    @NotBlank(message = "password is mandatory")
    private String password;
}

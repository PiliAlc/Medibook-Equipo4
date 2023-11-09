package com.medibook.controller.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {


    @NotBlank(message = "Nombre invalido: El campo no puede estar vacio")
    @NotNull(message = "Nombre invalido: El nombre es NULL")
    @Size(min = 2, max = 30, message = "Nombre invalido: Debe contener entre 3 y 30 caracteres")
    private String name;

    @NotBlank(message = "Apellido invalido: El campo no puede estar vacio")
    @NotNull(message = "Apellido invalido: El nombre es NULL")
    @Size(min = 2, max = 30, message = "Apellido invalido: Debe contener entre 3 y 30 caracteres")
    private String lastname;

    @Email
    @NotBlank(message = "Nombre de usuario invalido: El campo no puede estar vacio")
    @NotNull(message = "Nombre de usuario invalido: El nombre es NULL")
    private String username;

    @NotBlank
    private String password;

    private Set<String> roles;
}

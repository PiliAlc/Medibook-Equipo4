package com.medibook.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {


    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private Set<String> roles;
}

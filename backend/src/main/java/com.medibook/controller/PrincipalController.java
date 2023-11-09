package com.medibook.controller;


import com.medibook.controller.request.CreateUserDTO;
import com.medibook.entities.ERole;
import com.medibook.entities.RoleEntity;
import com.medibook.entities.Room;
import com.medibook.entities.UserEntity;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
   //Recupero los roles y creo una entidad de RoleEntity
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());
    //Creo el usuario
        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .name(createUserDTO.getName())
                .lastname(createUserDTO.getLastname())
                .roles(roles)
                .build();

    //Persisto el usuario y lo retorno
        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    /*@DeleteMapping("/deleteUser")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id ".concat(id);

    }*/
}

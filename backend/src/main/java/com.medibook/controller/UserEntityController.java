package com.medibook.controller;

import com.medibook.entities.UserEntity;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.service.UserEntityService;
import com.medibook.util.ValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserEntityController {

    private UserEntityService userEntityService;
    @Autowired
    public UserEntityController(UserEntityService userEntityService){

        this.userEntityService =  userEntityService;
    }

    @PostMapping("/addUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUserEntity(@RequestBody UserEntity userEntity) {

        userEntityService.addUser(userEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/editUsers")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> editUserEntity(@RequestBody UserEntity userEntity) throws ResourceNotFoundException {

        userEntityService.editUser(userEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listUsers")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<UserEntity>> listUserEntitites() throws  ResourceNotFoundException{

        List<UserEntity> userEntities = userEntityService.listUserEntitites();

        return ResponseEntity.ok(userEntities);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Optional<UserEntity>> searchById(@PathVariable String id) throws  ResourceNotFoundException{
        Optional<UserEntity> userEntity = userEntityService.searchById(Long.parseLong(id));
        if(ValidatorClass.isNumeric(id)){

            return ResponseEntity.ok (userEntity);

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
    }
    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Optional<UserEntity>> searchByUsername (@PathVariable String username) throws ResourceNotFoundException{
        Optional<UserEntity> userEntity = userEntityService.searchByUsername(username);
        if(!userEntity.get().getUsername().isEmpty()){
            return ResponseEntity.ok(userEntity);
        } else {
            throw new ResourceNotFoundException("El Usuario con el nombre " + username + "no existe" );
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable String id) throws ResourceNotFoundException {

        if(ValidatorClass.isNumeric(id)){

            userEntityService.deleteUserEntity(Long.parseLong(id));

            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
    }

}














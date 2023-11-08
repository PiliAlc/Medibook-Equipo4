package com.medibook.controller;

import com.medibook.entities.Typeroom;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.service.TypeRoomService;
import com.medibook.util.ValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/typerooms")
public class TypeRoomController {
    private TypeRoomService typeRoomService;

    @Autowired
    public TypeRoomController(TypeRoomService typeRoomService) {
        this.typeRoomService = typeRoomService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addType(@RequestBody Typeroom typeRoom) {

        typeRoomService.addType(typeRoom);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editTypeRoom(@RequestBody Typeroom typeRoom) throws ResourceNotFoundException {

        typeRoomService.editTypeRoom(typeRoom);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listtyperooms")
    public ResponseEntity<List<Typeroom>> listTypeRooms() throws ResourceNotFoundException {

        List<Typeroom> typeRooms = typeRoomService.listTypeRooms();

        return ResponseEntity.ok(typeRooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Typeroom>> searchByType_Id(@PathVariable String id) throws ResourceNotFoundException {
        Optional<Typeroom> typeRoom = typeRoomService.searchByType_Id(Long.parseLong(id));
        if (ValidatorClass.isNumeric(id)) {

            return ResponseEntity.ok(typeRoom);

        } else {

            throw new ResourceNotFoundException("El Id de la categoría debe se numérico");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTypeRoom(@PathVariable String id) throws ResourceNotFoundException {

        if (ValidatorClass.isNumeric(id)) {

            typeRoomService.deleteTypeRoom(Long.parseLong(id));

            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");

        } else {

            throw new ResourceNotFoundException("El Id de la categoría debe se numérico");
        }
    }
}


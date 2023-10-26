/*package com.medibook.controller;

import com.medibook.entities.TypeRoom;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.service.TypeRoomService;
import com.medibook.util.ValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addType(@RequestBody TypeRoom typeRoom) {

        typeRoomService.addType(typeRoom);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editTypeRoom(@RequestBody TypeRoom typeRoom) throws ResourceNotFoundException {

        typeRoomService.editTypeRoom(typeRoom);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TypeRoom>> listTypeRooms() throws ResourceNotFoundException {

        List<TypeRoom> typeRooms = typeRoomService.listTypeRooms();

        return ResponseEntity.ok(typeRooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TypeRoom>> searchByType_Id(@PathVariable String id) throws ResourceNotFoundException {
        Optional<TypeRoom> typeRoom = typeRoomService.searchByType_Id(Long.parseLong(id));
        if (ValidatorClass.isNumeric(id)) {

            return ResponseEntity.ok(typeRoom);

        } else {

            throw new ResourceNotFoundException("El Id de la categoría debe se numérico");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypeRoom(@PathVariable String id) throws ResourceNotFoundException {

        if (ValidatorClass.isNumeric(id)) {

            typeRoomService.deleteTypeRoom(Long.parseLong(id));

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

        } else {

            throw new ResourceNotFoundException("El Id de la categoría debe se numérico");
        }
    }
}
 */

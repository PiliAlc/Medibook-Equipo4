package com.medibook.controller;

import com.medibook.entities.Room;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.service.RoomService;
import com.medibook.util.ValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addRoom(@RequestBody Room room) {

        roomService.addRoom(room);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> changeRoom(@RequestBody Room room) throws ResourceNotFoundException {

        roomService.editRoom(room);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listrooms")
    public ResponseEntity<List<Room>> listRooms() throws  ResourceNotFoundException{

        List<Room> rooms = roomService.listRooms();

        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Room>> searchById(@PathVariable String id) throws  ResourceNotFoundException{
        Optional<Room> room = roomService.searchById(Long.parseLong(id));
        if(ValidatorClass.isNumeric(id)){

            return ResponseEntity.ok (room);

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Room>> searchByTuition (@PathVariable String name) throws ResourceNotFoundException{
        Optional<Room> room = roomService.searchByName(name);
        if(!room.get().getName().isEmpty()){
            return ResponseEntity.ok(room);
        } else {
            throw new ResourceNotFoundException("La sala con el nombre " + name + "no existe" );
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable String id) throws ResourceNotFoundException {

        if(ValidatorClass.isNumeric(id)){

            roomService.deleteRoom(Long.parseLong(id));

            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
     }
}

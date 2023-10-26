package com.medibook.controller;

import com.medibook.entities.Doctor;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.service.DoctorService;
import com.medibook.util.ValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService) {
            this.doctorService = doctorService;
        }

    @PostMapping()
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {

        doctorService.addDoctor(doctor);

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping()
     public ResponseEntity<?> changeDoctor(@RequestBody Doctor doctor) throws ResourceNotFoundException {

            doctorService.editDoctor(doctor);

            return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> listDoctors() throws  ResourceNotFoundException{

        List<Doctor> doctors = doctorService.listDoctors();

        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> searchById(@PathVariable String id) throws  ResourceNotFoundException{
        Optional<Doctor> doctor = doctorService.searchById(Long.parseLong(id));
        if(ValidatorClass.isNumeric(id)){

            return ResponseEntity.ok (doctor);

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
    }
    @GetMapping("/tuition/{tuition}")
    public ResponseEntity<Optional<Doctor>> searchByTuition (@PathVariable String tuition) throws ResourceNotFoundException{
        Optional<Doctor> doctor = doctorService.searchByTuition(tuition);
        if(!doctor.get().getTuition().isEmpty()){
            return ResponseEntity.ok(doctor);
        } else {
            throw new ResourceNotFoundException("El médico con la matrícula " + tuition + "no existe" );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws ResourceNotFoundException {

        if(ValidatorClass.isNumeric(id)){

            doctorService.deleteDoctor(Long.parseLong(id));

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

        } else {

            throw  new ResourceNotFoundException("El Id debe se numérico");
        }
    }

}


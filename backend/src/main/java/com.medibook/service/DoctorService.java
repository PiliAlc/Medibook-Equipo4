package com.medibook.service;


import com.medibook.entities.Doctor;

import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    private final static Logger logger = Logger.getLogger(DoctorService.class);

    //Método para agregar un doctor
    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public void addDoctor(Doctor doctor) {

        Doctor doctor1 = registerDoctor(doctor);

        logger.info("Se ha agregado el médico con id: " + doctor1.getId());
    }

    public void editDoctor(Doctor doctor) throws ResourceNotFoundException {

        String msg = "";

        Optional<Doctor> doctor1 = doctorRepository.findById(doctor.getId());

        if (doctor1.isEmpty()) {

            msg = "No se puede modificar el medico porque el id no existe ";

            throw new ResourceNotFoundException(msg);
        } else {


            registerDoctor(doctor);
            logger.info("Se modifica el medico con id: " + doctor1.get().getId());
        }
    }

    //Método para visualizar todos los medicos

    public List<Doctor> listDoctors() throws ResourceNotFoundException {

        List<Doctor> doctors = doctorRepository.findAll();

        logger.info("Se consulta todos los medicos");
        return doctors;
    }

    //Método para eliminar médico por Id.

    public void deleteDoctor(Long id) throws ResourceNotFoundException {

        if (doctorRepository.findById(id).isEmpty())

            throw new ResourceNotFoundException("No existe medico con id: " + id);

        doctorRepository.deleteById(id);

        logger.info("Se elimina el medico con Id: " + id);
    }


    //Método para buscar medico por matrícula

    public Optional<Doctor> searchByTuition(String tuition) throws ResourceNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findByTuition(tuition);


        if (doctor.isPresent()) {

            logger.info("Se consulta medico por matricula: " + doctor.get().getTuition());

        } else{

                throw new ResourceNotFoundException("No existe la matricula que esta buscando");
            }
        return doctor;

    }

    //Método para buscar medico por Id

    public Optional<Doctor> searchById(Long id) throws  ResourceNotFoundException{

        Optional<Doctor> doctor =  doctorRepository.findById(id);



        if(doctor.isPresent()){

            logger.info("Se consulta medico por Id: " + doctor.get().getId());}
        else{

            throw  new ResourceNotFoundException("No existe el medico con ese id: " + id);
        }
        return doctor;
    }

}
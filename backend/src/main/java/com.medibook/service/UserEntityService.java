package com.medibook.service;


import com.medibook.entities.UserEntity;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {
    @Autowired
    private UserRepository userRepository;

    private final static Logger logger = Logger.getLogger(RoomService.class);


    public UserEntity registerUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }


  public void addUser(UserEntity userEntity) {

        UserEntity userEntity1 = registerUser(userEntity);

        logger.info("Se ha agregado un usuario con id: " + userEntity1.getId());
    }

    public void editUser(UserEntity userEntity) throws ResourceNotFoundException {

        String msg = "";

        Optional<UserEntity> userEntity1 = userRepository.findById(userEntity.getId());

        if (userEntity1.isEmpty()) {

            msg = "No se puede modificar el usuario porque el id no existe ";

            throw new ResourceNotFoundException(msg);
        } else {


            registerUser(userEntity);
            logger.info("Se modifica el usuario con id: " + userEntity1.get().getId());
        }
    }

    public List<UserEntity> listUserEntitites() throws ResourceNotFoundException {

        List<UserEntity> userEntities = userRepository.findAll();

        logger.info("Se consulta todos los usuarios");

        return userEntities;
    }



    public void deleteUserEntity(Long id) throws ResourceNotFoundException {

        if (userRepository.findById(id).isEmpty())

            throw new ResourceNotFoundException("No existe el usuario con id: " + id);

        userRepository.deleteById(id);

        logger.info("Se elimina el usuario con Id: " + id);
    }

    public Optional<UserEntity> searchByUsername(String username) throws ResourceNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);


        if (userEntity.isPresent()) {

            logger.info("Se consulta por nombre d eusuario: " + userEntity.get().getName());

        } else{

            throw new ResourceNotFoundException("No existe el nombre de usuario que esta buscando");
        }
        return userEntity;

    }

    public Optional<UserEntity> searchById(Long id) throws  ResourceNotFoundException{

        Optional<UserEntity> userEntity =  userRepository.findById(id);



        if(userEntity.isPresent()){

            logger.info("Se consulta el usuario por Id: " + userEntity.get().getId());}
        else{

            throw  new ResourceNotFoundException("No existe el usuario con ese id: " + id);
        }
        return userEntity;
    }

}







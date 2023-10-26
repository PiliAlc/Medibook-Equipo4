package com.medibook.service;


import com.medibook.entities.TypeRoom;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.TypeRoomRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TypeRoomService {


    @Autowired
    private TypeRoomRepository typeRoomRepository;

    private final static Logger logger = Logger.getLogger(TypeRoomService.class);

    //Método para agregar una categoría
    public TypeRoom registerTypeRoom(TypeRoom typeRoom) {
        return typeRoomRepository.save(typeRoom);
    }


    public void addType(TypeRoom typeRoom) {

        TypeRoom typeRoom1 = registerTypeRoom(typeRoom);

        logger.info("Se ha agregado la categoría con id: " + typeRoom1.getType_id());
    }

    //Método para actualizar una categoría
    public void editTypeRoom(TypeRoom typeRoom) throws ResourceNotFoundException {

        String msg = "";

        Optional<TypeRoom> typeRoom1 = typeRoomRepository.findById(typeRoom.getType_id());

        if (typeRoom1.isEmpty()) {

            msg = "No se puede modificar la categoría porque el id no existe ";

            throw new ResourceNotFoundException(msg);
        } else {


            registerTypeRoom(typeRoom);
            logger.info("Se modifica la categoría con id: " + typeRoom1.get().getType_id());
        }
    }

    //Método para visualizar todas las categorías

    public List<TypeRoom> listTypeRooms() throws ResourceNotFoundException {

        List<TypeRoom> typeRooms = typeRoomRepository.findAll();

        logger.info("Se consulta todas las categorías");
        return typeRooms;
    }


    //Método para eliminar categoría por Id.

    public void deleteTypeRoom(Long id) throws ResourceNotFoundException {

        if (typeRoomRepository.findById(id).isEmpty())

            throw new ResourceNotFoundException("No existe la categoría con ese  id: " + id);

        typeRoomRepository.deleteById(id);

        logger.info("Se elimina la categoría con Id: " + id);
    }

    //Método para buscar Categoría por Id

    public Optional<TypeRoom> searchByType_Id(Long id) throws  ResourceNotFoundException{

        Optional<TypeRoom> typeRoom =  typeRoomRepository.findById(id);



        if(typeRoom.isPresent()){

            logger.info("Se consulta la categoría por Id: " + typeRoom.get().getType_id());}
        else{

            throw  new ResourceNotFoundException("No existe la categoría con ese id: " + id);
        }
        return typeRoom;
    }


}



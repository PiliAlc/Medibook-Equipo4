package com.medibook.service;


import com.medibook.entities.Room;
import com.medibook.entities.Typeroom;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.TypeRoomRepository;
import jakarta.transaction.Transactional;
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
    public Typeroom registerTypeRoom(Typeroom typeRoom) {
        return typeRoomRepository.save(typeRoom);
    }


    public void addType(Typeroom typeRoom) {

        Typeroom typeRoom1 = registerTypeRoom(typeRoom);

        logger.info("Se ha agregado la categoría con id: " + typeRoom1.getId());
    }

    //Método para actualizar una categoría
    public void editTypeRoom(Typeroom typeRoom) throws ResourceNotFoundException {

        String msg = "";

        Optional<Typeroom> typeRoom1 = typeRoomRepository.findById(typeRoom.getId());

        if (typeRoom1.isEmpty()) {

            msg = "No se puede modificar la categoría porque el id no existe ";

            throw new ResourceNotFoundException(msg);
        } else {


            registerTypeRoom(typeRoom);
            logger.info("Se modifica la categoría con id: " + typeRoom1.get().getId());
        }
    }

    //Método para visualizar todas las categorías

    public List<Typeroom> listTypeRooms() throws ResourceNotFoundException {

        List<Typeroom> typeRooms = typeRoomRepository.findAll();

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

    public Optional<Typeroom> searchByType_Id(Long id) throws  ResourceNotFoundException{

        Optional<Typeroom> typeRoom =  typeRoomRepository.findById(id);



        if(typeRoom.isPresent()){

            logger.info("Se consulta la categoría por Id: " + typeRoom.get().getId());}
        else{

            throw  new ResourceNotFoundException("No existe la categoría con ese id: " + id);
        }
        return typeRoom;
    }


    public Optional<Typeroom> searchById(Long id)  throws  ResourceNotFoundException {
        Optional<Typeroom> typeroom =  typeRoomRepository.findId(id);

        if(typeroom.isPresent()){

            logger.info("Se consulta sala por Id: " + typeroom.get().getId());}
        else{

            throw  new ResourceNotFoundException("No existe la sala con ese id: " + id);
        }
        return typeroom;
    }

    @Transactional
    public void saveImageTyperRoom(Typeroom typeroom) {
        typeRoomRepository.save(typeroom);
    }
}
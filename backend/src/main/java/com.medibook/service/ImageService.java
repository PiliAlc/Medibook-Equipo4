package com.medibook.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.medibook.entities.Image;
import com.medibook.entities.Room;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageService {

    //Inyectamos dependencia de cloudinary
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RoomService roomService;

    //El método uploadImage maneja la subida de imágenes a Cloudinary
    //y la creación de una nueva entrada en la tabla “images”.
    public void uploadImage(MultipartFile file, Long idRoom) throws IOException {
        //sube el archivo de imagen a Cloudinary y obtiene la URL de la imagen subida.
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        //almacena la URL de la imagen subida en una variable.
        String url = (String) uploadResult.get("url");

        Image image = new Image(); //se crea una nueva isntancia de clase image
        image.setPath(url); //establece la URL de la imagen en la instancia de la clase Image

        Room room = null;

        try {
            //busca una habitación en la base de datos utilizando el ID de habitación proporcionado.
            Optional<Room> roomOptional = roomService.searchById(idRoom);
            room = roomOptional.get(); //obtiene la habitación de la base de datos.
            room.getImages().add(image); //agrega la instancia de la clase Image a la lista de imágenes de la habitación.
            roomService.saveImageRoom(room); //guarda la habitación actualizada en la base de datos.
        } catch (Exception | ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }

        imageRepository.save(image); //guarda la instancia de la clase Image en la BD
    }

}

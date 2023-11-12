package com.medibook.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.medibook.entities.Image;
import com.medibook.entities.Room;
import com.medibook.entities.Typeroom;
import com.medibook.exceptions.ResourceNotFoundException;
import com.medibook.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
    @Autowired
    private TypeRoomService typeRoomService;

    //El método uploadImage maneja la subida de imágenes a Cloudinary
    //y la creación de una nueva entrada en la tabla “images”.
    public void uploadImages(List<MultipartFile> files, Long roomId) throws IOException {
        Room room;

        try {
            Optional<Room> roomOptional = roomService.searchById(roomId);
            room = roomOptional.orElseThrow(() -> new ResourceNotFoundException("Room not found")); // Manejar si la habitación no se encuentra

            for (MultipartFile file : files) {
                Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String url = (String) uploadResult.get("url");

                Image image = new Image();
                image.setPath(url);
                room.getImages().add(image);
            }

            roomService.saveImageRoom(room);
        } catch (Exception | ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }

        // imageRepository.save(image); //guarda la instancia de la clase Image en la BD
    }

    public void uploadTyperoomImage(List<MultipartFile> files, Long idTyperoom) {
        Typeroom typeroom;

        try {
            Optional<Typeroom> typeroomOptional = typeRoomService.searchById(idTyperoom);
            typeroom = typeroomOptional.orElseThrow(() -> new ResourceNotFoundException("typeroom not found"));

            for (MultipartFile file : files) {
                Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String url = (String) uploadResult.get("url");

                Image image = new Image();
                image.setPath(url);
                typeroom.setImage(image);
            }

            typeRoomService.saveImageTyperRoom(typeroom);
        } catch (Exception | ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

package com.medibook.service;

import com.medibook.entities.Image;
import com.medibook.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageService {

    // Inyecta la ruta de almacenamiento desde la configuración
    @Value("${image.upload.path}")
    private String uploadPath;

    // Inyecta un repositorio de imágenes
    @Autowired
    private ImageRepository imageRepository;

    // Método para guardar una imagen
    public void saveImage(MultipartFile file) throws IOException {
        // Convierte la ruta de almacenamiento en una cadena
        String imagePath = Paths.get(uploadPath).toString();

        // Escribe el contenido del archivo subido en la ubicación especificada
        Files.write(Paths.get(imagePath), file.getBytes());

        // Crea una instancia de la entidad 'Image'
        Image image = new Image();
        // Establece la ruta de la imagen en la entidad
        image.setPath(imagePath);

        // Guarda la entidad 'Image' en la base de datos a través del repositorio
        imageRepository.save(image);
    }

}

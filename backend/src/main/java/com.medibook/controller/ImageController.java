package com.medibook.controller;

import com.medibook.entities.Image;
import com.medibook.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    // Maneja las solicitudes GET a la ruta "/images/{id}"
    @GetMapping("/images/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            // Si se encuentra la imagen en la base de datos
            Image image = imageOptional.get();
            // Obtiene la ruta de la imagen desde la entidad Image
            Path imagePath = Paths.get(image.getPath());
            // Lee los bytes de la imagen desde la ubicación especificada en el sistema de archivos
            byte[] imageBytes = Files.readAllBytes(imagePath);
            // Configura las cabeceras de la respuesta HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            // Si no se encuentra la imagen, devuelve una respuesta HTTP con estado NOT FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


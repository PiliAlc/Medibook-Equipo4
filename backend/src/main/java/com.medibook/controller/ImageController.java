package com.medibook.controller;

import com.medibook.entities.Image;
import com.medibook.repository.ImageRepository;
import com.medibook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("path") List<MultipartFile> files, @RequestParam(value = "room_id", required = false) Long idRoom) throws IOException {
        imageService.uploadImages(files, idRoom);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/upload/typeroom")
    public ResponseEntity<?> uploadTyperoomImage(@RequestParam("path") List<MultipartFile> files, @RequestParam(value = "typeroom_id", required = false) Long idTyperoom) throws IOException {
        imageService.uploadTyperoomImage(files, idTyperoom);

        return ResponseEntity.ok().build();
    }
}


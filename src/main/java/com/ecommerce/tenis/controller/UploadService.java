package com.ecommerce.tenis.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadService {

    private static final String UPLOAD_DIR = "uploads"; 

    public String salvarImagem(MultipartFile file) throws IOException {
    
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR, fileName);

        Files.copy(file.getInputStream(), filePath);


        return "/uploads/" + fileName;
    }
}

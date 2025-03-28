package com.ecommerce.tenis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.tenis.service.UploadService;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UploadService uploadService;

    @Autowired
    public UsuarioController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/{id}/uploadProfilePicture")
    public ResponseEntity<Map<String, String>> uploadProfilePicture(@PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();
        try {
            System.out.println("Recebendo upload para usuário ID: " + id);

            if (file.isEmpty()) {
                response.put("error", "Arquivo não pode estar vazio.");
                return ResponseEntity.badRequest().body(response);
            }

            System.out.println("Arquivo recebido: " + file.getOriginalFilename());

            String fileName = uploadService.uploadProfilePicture(file);

            System.out.println("Arquivo salvo como: " + fileName);

            // Aqui você pode salvar o nome do arquivo no banco de dados associando ao
            // usuário

            response.put("message", "Upload realizado com sucesso!");
            response.put("fileName", fileName);
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento: " + e.getMessage());
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace(); // Isso ajudará a identificar o erro no console do Spring Boot
            response.put("error", "Ocorreu um erro inesperado.");
            return ResponseEntity.internalServerError().body(response);
        }
    }

}

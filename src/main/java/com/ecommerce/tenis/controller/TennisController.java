package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.service.TennisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tennis")
@CrossOrigin(origins = "http://localhost:3000")
public class TennisController {

    private final TennisService service;
    private final String uploadDir = "uploads";  

    public TennisController(TennisService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tennis>> listarTodos() {
        List<Tennis> tenisList = service.listarTodos();
        return ResponseEntity.ok(tenisList);
    }

    @PostMapping
    public ResponseEntity<Tennis> cadastrar(@RequestParam("nome") String nome,
                                            @RequestParam("numero") int numero,
                                            @RequestParam("cor") String cor,
                                            @RequestParam("preco") double preco,
                                            @RequestParam("estoque") int estoque,
                                            @RequestParam("imagem") MultipartFile imagem) {
        try {
            // Cria um diretório se não existir
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Gerar nome único para o arquivo
            String fileName = UUID.randomUUID().toString() + "-" + imagem.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            // Salvar a imagem na pasta
            Files.copy(imagem.getInputStream(), filePath);

            // Criar novo objeto Tennis
            Tennis novoTennis = new Tennis();
            novoTennis.setNome(nome);
            novoTennis.setNumero(numero);
            novoTennis.setCor(cor);
            novoTennis.setPreco(preco);
            novoTennis.setEstoque(estoque);
            novoTennis.setImagem("/uploads/" + fileName); // Caminho acessível pela API

            Tennis tenisCadastrado = service.cadastrar(novoTennis);

            return ResponseEntity.status(HttpStatus.CREATED).body(tenisCadastrado);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
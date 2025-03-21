package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.service.TennisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tennis")
@CrossOrigin(origins = "http://localhost:3000")
public class TennisController {

    private final TennisService service;
    private final UploadService uploadService;

    public TennisController(TennisService service, UploadService uploadService) {
        this.service = service;
        this.uploadService = uploadService;
    }

    @GetMapping
    public ResponseEntity<List<Tennis>> listarTodos() {
        List<Tennis> tenisList = service.listarTodos();
        return ResponseEntity.ok(tenisList);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Tennis>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Tennis> tenisList = service.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(tenisList);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestParam("nome") String nome,
                                       @RequestParam("numero") int numero,
                                       @RequestParam("cor") String cor,
                                       @RequestParam("preco") double preco,
                                       @RequestParam("estoque") int estoque,
                                       @RequestParam("imagem") MultipartFile imagem,
                                       @RequestParam("usuarioId") Long usuarioId) {
        try {
            String caminhoImagem = uploadService.salvarImagem(imagem);
            
            Tennis novoTennis = new Tennis(nome, numero, cor, preco, estoque, caminhoImagem);
            Tennis tenisCadastrado = service.cadastrar(novoTennis, usuarioId);

            return ResponseEntity.status(HttpStatus.CREATED).body(tenisCadastrado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a imagem: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar o tênis: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir: " + e.getMessage());
        }
    }

    @PostMapping("/upload-imagem")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file) {
        try {
            String caminhoImagem = uploadService.salvarImagem(file);
            return ResponseEntity.ok(caminhoImagem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}
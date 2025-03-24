package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.model.Usuario;
import com.ecommerce.tenis.service.TennisService;
import com.ecommerce.tenis.service.UploadService;
import com.ecommerce.tenis.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tennis")
@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do frontend no localhost:3000
public class TennisController {

    private final TennisService service;
    private final UploadService uploadService;
    private final UsuarioRepository usuarioRepository; // Repositório para acessar o usuário

    public TennisController(TennisService service, UploadService uploadService, UsuarioRepository usuarioRepository) {
        this.service = service;
        this.uploadService = uploadService;
        this.usuarioRepository = usuarioRepository;
    }

    // Endpoint para listar todos os tênis
    @GetMapping
    public ResponseEntity<List<Tennis>> listarTodos() {
        try {
            List<Tennis> tenisList = service.listarTodos();
            return ResponseEntity.ok(tenisList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Endpoint para listar tênis por usuário
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Tennis>> listarPorUsuario(@PathVariable Long usuarioId) {
        try {
            List<Tennis> tenisList = service.listarPorUsuario(usuarioId);
            if (tenisList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tenisList); // Retorna código 204 se a lista
                                                                                     // estiver vazia
            }
            return ResponseEntity.ok(tenisList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para cadastrar um novo tênis
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestParam("nome") String nome,
            @RequestParam("numero") int numero,
            @RequestParam("cor") String cor,
            @RequestParam("preco") double preco,
            @RequestParam("marca") String marca,
            @RequestParam("imagem") MultipartFile imagem,
            @RequestParam("usuarioId") Long usuarioId) {
        try {
            // Verificar se o usuário existe
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Erro: Usuário não encontrado"));

            // Salvando a imagem do tênis
            String caminhoImagem = uploadService.salvarImagem(imagem);

            // Criando o objeto Tennis
            Tennis novoTennis = new Tennis(nome, cor, numero, caminhoImagem, preco, marca, usuario);

            // Cadastrando o novo tênis no banco
            Tennis tenisCadastrado = service.cadastrar(novoTennis, usuarioId);

            return ResponseEntity.status(HttpStatus.CREATED).body(tenisCadastrado); // Retorna 201 com o objeto criado
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a imagem: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar o tênis: " + e.getMessage());
        }
    }

    // Endpoint para excluir um tênis
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao excluir: " + e.getMessage());
        }
    }

    // Endpoint para fazer upload de imagens
    @PostMapping("/upload-imagem")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file) {
        try {
            String caminhoImagem = uploadService.salvarImagem(file);
            return ResponseEntity.ok(caminhoImagem); // Retorna o caminho da imagem salva
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}
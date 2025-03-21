package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Usuario;
import com.ecommerce.tenis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    // Método para registrar um novo usuário
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        try {
            // Chamando o serviço para cadastrar o usuário
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (Exception e) {
            // Caso ocorra algum erro, retornando a mensagem de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Erro ao registrar o usuário: " + e.getMessage() + "\"}");
        }
    }

    // Método para realizar o login do usuário
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());

        if (usuarioAutenticado.isPresent()) {
            // Retorna o usuário autenticado dentro do campo "user" na resposta JSON
            return ResponseEntity.ok(
                    "{\"message\": \"Login bem-sucedido!\", \"user\": " +
                            toJson(usuarioAutenticado.get()) + "}");
        } else {
            // Caso o login falhe, retornando um erro no formato JSON
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"message\": \"Falha no login! Verifique suas credenciais.\"}");
        }
    }

    // Método auxiliar para converter o usuário em JSON (para evitar manualmente
    // fazer isso no retorno)
    private String toJson(Usuario usuario) {
        return "{" +
                "\"id\": \"" + usuario.getId() + "\"," +
                "\"nome\": \"" + usuario.getNome() + "\"," +
                "\"email\": \"" + usuario.getEmail() + "\"" +
                "}";
    }
}

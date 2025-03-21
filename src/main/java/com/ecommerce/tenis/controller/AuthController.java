package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Usuario;
import com.ecommerce.tenis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth") 
@CrossOrigin(origins = "http://localhost:3000") 
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());

        if (usuarioAutenticado.isPresent()) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(401).body("Falha no login! Verifique suas credenciais.");
        }
    }
}

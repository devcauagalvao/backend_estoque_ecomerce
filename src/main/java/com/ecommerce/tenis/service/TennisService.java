package com.ecommerce.tenis.service;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.model.Usuario;
import com.ecommerce.tenis.repository.TennisRepository;
import com.ecommerce.tenis.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisService {

    private final TennisRepository tennisRepository;
    private final UsuarioRepository usuarioRepository;

    public TennisService(TennisRepository tennisRepository, UsuarioRepository usuarioRepository) {
        this.tennisRepository = tennisRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Tennis> listarTodos() {
        return tennisRepository.findAll(); 
    }

    public List<Tennis> listarPorUsuario(Long usuarioId) {
        return tennisRepository.findByUsuarioId(usuarioId);
    }

    public Tennis cadastrar(Tennis tennis, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        tennis.setUsuario(usuario);
        return tennisRepository.save(tennis);
    }

    public void excluir(Long id) {
        tennisRepository.deleteById(id);  
    }
}
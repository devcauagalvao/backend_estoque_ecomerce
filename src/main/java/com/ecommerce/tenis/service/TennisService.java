package com.ecommerce.tenis.service;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.model.Usuario;
import com.ecommerce.tenis.repository.TennisRepository;
import com.ecommerce.tenis.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
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

    // Listar tênis por usuário específico
    public List<Tennis> listarPorUsuario(Long usuarioId) {
        return tennisRepository.findByUsuarioId(usuarioId);
    }

    // Cadastrar um novo tênis
    @Transactional
    public Tennis cadastrar(Tennis tennis, Long usuarioId) {
        // Verifica se o usuário existe
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Erro: Usuário com ID " + usuarioId + " não encontrado."));

        // Associar o usuário ao tênis
        tennis.setUsuario(usuario);

        // Salvar o tênis no repositório
        return tennisRepository.save(tennis);
    }

    // Excluir um tênis por ID
    public void excluir(Long id) {
        // Verifica se o tênis existe
        Tennis tennis = tennisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro: Tênis com ID " + id + " não encontrado."));

        // Excluir o tênis do banco de dados
        tennisRepository.delete(tennis);
    }
}

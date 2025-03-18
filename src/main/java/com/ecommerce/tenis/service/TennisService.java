package com.ecommerce.tenis.service;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.repository.TennisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisService {


    private final TennisRepository repository;

   
    public TennisService(TennisRepository repository) {
        this.repository = repository;
    }

  
    public List<Tennis> listarTodos() {
        return repository.findAll(); 
    }

    
    public Tennis cadastrar(Tennis tennis) {
        return repository.save(tennis);  
    }


    public void excluir(Long id) {
        repository.deleteById(id);  
    }
}

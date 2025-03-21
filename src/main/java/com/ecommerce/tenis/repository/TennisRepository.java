package com.ecommerce.tenis.repository;

import com.ecommerce.tenis.model.Tennis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisRepository extends JpaRepository<Tennis, Long> {

    List<Tennis> findByUsuarioId(Long usuarioId);
  
}

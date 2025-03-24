package com.ecommerce.tenis.repository;

import com.ecommerce.tenis.model.Tennis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TennisRepository extends JpaRepository<Tennis, Long> {

    @Query("SELECT t FROM Tennis t WHERE t.usuario.id = :usuarioId")
    List<Tennis> findByUsuarioId(Long usuarioId);
}

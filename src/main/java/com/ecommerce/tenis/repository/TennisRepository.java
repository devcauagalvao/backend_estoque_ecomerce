package com.ecommerce.tenis.repository;

import com.ecommerce.tenis.model.Tennis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisRepository extends JpaRepository<Tennis, Long> {
  
}

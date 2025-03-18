package com.ecommerce.tenis.controller;

import com.ecommerce.tenis.model.Tennis;
import com.ecommerce.tenis.service.TennisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tennis")
@CrossOrigin(origins = "http://localhost:3000")  
public class TennisController {

    private final TennisService service;

 
    public TennisController(TennisService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Tennis>> listarTodos() {
        List<Tennis> tenisList = service.listarTodos();
        return ResponseEntity.ok(tenisList);  
    }

  
    @PostMapping
    public ResponseEntity<Tennis> cadastrar(@RequestBody Tennis tennis) {
        if (tennis == null) {
            return ResponseEntity.badRequest().build(); 
        }
        
        Tennis novoTennis = service.cadastrar(tennis);  
        
        if (novoTennis != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(novoTennis);  
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            service.excluir(id); 
            return ResponseEntity.noContent().build();  
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }
}

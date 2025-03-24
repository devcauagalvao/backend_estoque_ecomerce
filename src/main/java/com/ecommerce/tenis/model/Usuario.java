package com.ecommerce.tenis.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // Importar para usar @JsonIgnore
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Ignora a serialização da lista de tênis para evitar recursão infinita
    private List<Tennis> tenis;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tennis> getTenis() {
        return tenis;
    }

    public void setTenis(List<Tennis> tenis) {
        this.tenis = tenis;
    }
}

package com.ecommerce.tenis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tennis")
public class Tennis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cor;
    private int numero;

    public Tennis() {}

    public Tennis(String nome, String cor, int numero) {
        this.nome = nome;
        this.cor = cor;
        this.numero = numero;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

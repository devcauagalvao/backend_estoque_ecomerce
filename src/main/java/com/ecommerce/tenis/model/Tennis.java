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

    @Column(nullable = true) 
    private String imagem;

    private double preco;  // Campo para armazenar o preço
    private int estoque;   // Campo para armazenar o estoque

    // Construtor vazio
    public Tennis() {}

    // Construtor com todos os campos
    public Tennis(String nome, String cor, int numero, String imagem, double preco, int estoque) {
        this.nome = nome;
        this.cor = cor;
        this.numero = numero;
        this.imagem = imagem;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Getters e Setters
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

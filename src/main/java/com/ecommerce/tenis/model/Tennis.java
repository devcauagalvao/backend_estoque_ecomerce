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

    private double preco;  
    private int estoque;   

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Tennis(String nome2, int numero2, String cor2, double preco2, int estoque2, String caminhoImagem) {}

    public Tennis(String nome, String cor, int numero, String imagem, double preco, int estoque, Usuario usuario) {
        this.nome = nome;
        this.cor = cor;
        this.numero = numero;
        this.imagem = imagem;
        this.preco = preco;
        this.estoque = estoque;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

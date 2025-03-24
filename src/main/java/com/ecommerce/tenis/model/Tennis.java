package com.ecommerce.tenis.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // Importar para usar @JsonBackReference
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
    private String marca;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference // Impede que o campo 'usuario' seja serializado na resposta JSON
    private Usuario usuario;

    // Construtor padrão (obrigatório para o Hibernate)
    public Tennis() {
    }

    // Construtor parametrizado com a ordem dos parâmetros corrigida
    public Tennis(String nome, String cor, int numero, String imagem, double preco, String marca, Usuario usuario) {
        this.nome = nome;
        this.cor = cor;
        this.numero = numero;
        this.imagem = imagem; // Corrigido a ordem do parâmetro imagem
        this.preco = preco;
        this.marca = marca;
        this.usuario = usuario;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

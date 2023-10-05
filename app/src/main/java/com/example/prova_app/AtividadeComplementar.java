package com.example.prova_app;

import java.io.Serializable;

public class AtividadeComplementar implements Serializable {
    private String nome;
    private String email;
    private String descricao;
    private String horas;
    private String categoria;

    public AtividadeComplementar(String nome, String email, String descricao, String horas, String categoria) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.horas = horas;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "Descrição: " + descricao + "\n" +
                "Horas: " + horas + "\n" +
                "Categoria: " + categoria + "\n";
    }
}

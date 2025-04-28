package com.darrieuxinfo.RestAPI.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    @OneToMany
    private List<Nota> listaNotas;

    public Aluno() {

    }


    public Aluno (Long id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Nota> getNotas() {
        return this.listaNotas;
    }

    public void setNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }


}

package com.darrieuxinfo.RestAPI.models;

import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nota;

    @ManyToOne
    @JoinColumn(name="alunoId", nullable = false)
    private Aluno aluno;

    public Nota() {

    }

    public Nota(Long id, double nota, Aluno aluno) {
        this.id = id;
        this.nota = nota;
        this.aluno = aluno;
    }

    public Long getId() {
        return this.id;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}

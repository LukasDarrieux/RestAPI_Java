package com.darrieuxinfo.RestAPI.dto;

public class NotaDTO {

    private double nota;
    private Long alunoId;

    public NotaDTO(double nota, Long alunoId) {
        this.nota = nota;
        this.alunoId = alunoId;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Long getAlunoId() {
        return this.alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

}

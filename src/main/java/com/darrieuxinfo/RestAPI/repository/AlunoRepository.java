package com.darrieuxinfo.RestAPI.repository;

import com.darrieuxinfo.RestAPI.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

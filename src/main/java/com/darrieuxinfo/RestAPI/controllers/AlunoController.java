package com.darrieuxinfo.RestAPI.controllers;

import com.darrieuxinfo.RestAPI.dto.AlunoDTO;
import com.darrieuxinfo.RestAPI.models.Aluno;
import com.darrieuxinfo.RestAPI.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Operation(summary="Retorna todos os alunos", description = "Retorna uma lista de alunos")
    @GetMapping
    public List<Aluno> get() {
        return alunoRepository.findAll();
    }

    @Operation(summary="Retorna um aluno a partir de um id informado", description = "Retorna um aluno")
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(Long id) {
        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (!aluno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aluno.get());
    }


    @Operation(summary="Adiciona um aluno a lista de alunos", description = "Adiciona um aluno")
    @PostMapping
    public ResponseEntity<Aluno> post(AlunoDTO alunoDTO){

        Aluno aluno = new Aluno(null, alunoDTO.getNome(), alunoDTO.getIdade());
        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    @Operation(summary="Atualiza um aluno a partir do id informado", description = "Atualiza um aluno")
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> put(Long id, AlunoDTO alunoDTO) {

        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (!aluno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        aluno.get().setNome(alunoDTO.getNome());
        aluno.get().setIdade(alunoDTO.getIdade());

        alunoRepository.save(aluno.get());

        return ResponseEntity.ok(aluno.get());
    }

    @Operation(summary="Exclui um aluno a partir de um id informado", description = "Exclui um aluno")
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(Long id) {
        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (!aluno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        alunoRepository.delete(aluno.get());
        return ResponseEntity.noContent().build();
    }

}

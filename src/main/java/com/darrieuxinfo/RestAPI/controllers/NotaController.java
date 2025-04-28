package com.darrieuxinfo.RestAPI.controllers;

import com.darrieuxinfo.RestAPI.dto.NotaDTO;
import com.darrieuxinfo.RestAPI.models.Aluno;
import com.darrieuxinfo.RestAPI.models.Nota;
import com.darrieuxinfo.RestAPI.repository.AlunoRepository;
import com.darrieuxinfo.RestAPI.repository.NotaRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nota")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Operation(summary = "Retorna todas as notas", description = "Retorna uma lista de notas")
    @GetMapping
    public List<Nota> get() {
        return notaRepository.findAll();
    }

    @Operation(summary = "Adiciona uma nota", description = "Adiciona uma nota")
    @PostMapping
    public ResponseEntity<Nota> post(NotaDTO notaDTO) {

        Optional<Aluno> aluno = alunoRepository.findById(notaDTO.getAlunoId());

        if (!aluno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Nota nota = new Nota(null, notaDTO.getNota(), aluno.get());

        notaRepository.save(nota);
        return ResponseEntity.ok(nota);

    }

    @Operation(summary = "Atualiza uma nota a partir do Id informado", description = "Atualiza uma nota")
    @PutMapping("/{id}")
    public ResponseEntity<Nota> put(Long id, NotaDTO notaDTO) {

        if (id == 0) {
            ResponseEntity.badRequest().build();
        }

        Optional<Nota> nota = notaRepository.findById(id);
        if (!nota.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        nota.get().setNota(notaDTO.getNota());
        notaRepository.save(nota.get());

        return ResponseEntity.ok(nota.get());
    }

    @Operation(summary = "Exclui uma nota a partir do Id informado", description = "Exclui uma nota")
    @DeleteMapping("/{id}")
    public ResponseEntity<Nota> delete(Long id) {

        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Nota> nota = notaRepository.findById(id);
        if(!nota.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        notaRepository.delete(nota.get());
        return ResponseEntity.noContent().build();
    }
}

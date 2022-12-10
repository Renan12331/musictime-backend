package com.musictime.aluno.controller;

import com.musictime.aluno.model.Aluno;
import com.musictime.aluno.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@AllArgsConstructor
public class AlunoController {

private final AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> list(){
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        return alunoRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno create(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno){
        return alunoRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(aluno.getName());
                    recordFound.setMatricula(aluno.getMatricula());
                    recordFound.setCpf(aluno.getCpf());
                    recordFound.setEndereco(aluno.getEndereco());
                    recordFound.setCurso(aluno.getCurso());
                    Aluno updated = alunoRepository.save(recordFound);
                    return ResponseEntity.ok().body(recordFound);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return alunoRepository.findById(id)
                .map(recordFound -> {
                    alunoRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

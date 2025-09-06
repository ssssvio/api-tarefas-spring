package com.example.demo.controller;

import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.TarefaRequestDTO;
import jakarta.validation.Valid;
import com.example.demo.dto.UpdateTarefaDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa(dto.getNome(), dto.getDataEntrega(), dto.getResponsavel());
        Tarefa salva = tarefaRepository.save(tarefa);
        return ResponseEntity.status(201).body(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @PathVariable Long id,
            @RequestBody UpdateTarefaDTO dto
    ) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setNome(dto.getNome());
            tarefa.setDataEntrega(dto.getDataEntrega());
            tarefa.setResponsavel(dto.getResponsavel());
            Tarefa atualizado = tarefaRepository.save(tarefa);
            return ResponseEntity.ok(atualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
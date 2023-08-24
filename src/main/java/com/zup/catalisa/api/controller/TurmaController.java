package com.zup.catalisa.api.controller;

import com.zup.catalisa.api.assembler.TurmaModelAssembler;
import com.zup.catalisa.api.model.saida.TurmaModel;
import com.zup.catalisa.model.Turma;
import com.zup.catalisa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private TurmaModelAssembler turmaModelAssembler;


    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> buscarPorId(@PathVariable Long id) {
        Optional<Turma> turmaOptional = turmaService.buscaPorId(id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            TurmaModel turmaModel = turmaModelAssembler.toModel(turma);
            return ResponseEntity.ok(turmaModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Turma cadastrar(@RequestBody Turma turma) {

        return turmaService.cadastrar(turma);

        //return turmaModelAssembler.toModel(turmaService.cadastrar(turma));

    }
}

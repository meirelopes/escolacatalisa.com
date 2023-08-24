package com.zup.catalisa.api.controller;

import com.zup.catalisa.model.Curso;
import com.zup.catalisa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {

        return cursoService.listar();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {

        Optional<Curso> curso = cursoService.listarPorId(id);

        if (curso.isPresent()) {

            return ResponseEntity.ok(curso.get());

        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {

        cursoService.excluir(id);

    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {

        return cursoService.cadastrar(curso);

    }

}

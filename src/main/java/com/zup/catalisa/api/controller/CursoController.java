package com.zup.catalisa.api.controller;

import com.zup.catalisa.model.Curso;
import com.zup.catalisa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
public class        CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {

        return cursoService.listar();

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

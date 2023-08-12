package com.zup.catalisa.controller;

import com.zup.catalisa.model.Disciplina;
import com.zup.catalisa.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listar() {

        return disciplinaService.listar();

    }
    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina) {

        return disciplinaService.cadastrar(disciplina);

    }


}

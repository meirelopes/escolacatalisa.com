package com.zup.catalisa.controller;

import com.zup.catalisa.model.Turma;
import com.zup.catalisa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;



    @PostMapping
    public Turma cadastrar(@RequestBody Turma turma) {

        return turmaService.cadastrar(turma);

    }
}

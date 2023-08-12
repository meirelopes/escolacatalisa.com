package com.zup.catalisa.controller;

import com.zup.catalisa.model.Aluno;
import com.zup.catalisa.model.Matricula;
import com.zup.catalisa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> listar() {

        return matriculaService.listar();

    }



}

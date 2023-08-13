package com.zup.catalisa.api.controller;

import com.zup.catalisa.api.model.saida.ProfessorDtoSaida;
import com.zup.catalisa.model.Professor;
import com.zup.catalisa.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/professores")
@RestController
public class ProfessorController {
    @Autowired
    ProfessorService professoresService;

    @GetMapping
    public List<Professor> listar() {

       return professoresService.listar();

    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        professoresService.excluir(id);

    }

    @PostMapping
    public ProfessorDtoSaida cadastrar(@RequestBody Professor professor) {
        Professor professorSalvo = professoresService.cadastrar(professor);
        ProfessorDtoSaida professorDtoSaida = new ProfessorDtoSaida();

        professorDtoSaida.setId(professorSalvo.getId());
        professorDtoSaida.setNome(professorSalvo.getNome());
        professorDtoSaida.setEmail(professorSalvo.getEmail());

        return professorDtoSaida;

    }

}

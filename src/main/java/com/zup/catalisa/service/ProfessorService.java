package com.zup.catalisa.service;

import com.zup.catalisa.model.Professor;
import com.zup.catalisa.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    //Listar todos os professores
    public List<Professor> listar(){

        return professorRepository.findAll();

    }

    public Professor cadastrar(Professor professor) {

        return professorRepository.save(professor);

    }

    public void excluir(Long id) {

        professorRepository.deleteById(id);

    }
}

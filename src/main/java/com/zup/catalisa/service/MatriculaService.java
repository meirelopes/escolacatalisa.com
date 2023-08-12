package com.zup.catalisa.service;

import com.zup.catalisa.model.Matricula;
import com.zup.catalisa.repository.AlunoRepository;
import com.zup.catalisa.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Matricula> listar() {

        return matriculaRepository.findAll();

    }

    public void salvarMatricula(Matricula matricula) {

        matriculaRepository.save(matricula);

    }

}

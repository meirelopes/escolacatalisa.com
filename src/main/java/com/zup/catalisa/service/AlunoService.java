package com.zup.catalisa.service;

import com.zup.catalisa.dto.saida.AlunoMatriculaDtoSaida;
import com.zup.catalisa.model.Aluno;
import com.zup.catalisa.model.Matricula;
import com.zup.catalisa.repository.AlunoRepository;
import com.zup.catalisa.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Aluno> listar() {

        return alunoRepository.findAll();

    }

    public void excluir(Long id) {

        alunoRepository.deleteById(id);

    }

    @Transactional
    public Aluno cadastrar(Aluno aluno) {

        return alunoRepository.save(aluno);

    }

}



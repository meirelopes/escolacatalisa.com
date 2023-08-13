package com.zup.catalisa.service;

import com.zup.catalisa.api.controller.AlunoController;
import com.zup.catalisa.model.Aluno;
import com.zup.catalisa.model.Turma;
import com.zup.catalisa.repository.TurmaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);

    public Optional<Turma> buscaPorId(Long id) {

        return turmaRepository.findById(id);

    }


    public Turma cadastrar(Turma turma) {
        logger.debug(turma.getCurso().getNome());


        return turmaRepository.save(turma);

    }

}

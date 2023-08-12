package com.zup.catalisa.service;

import com.zup.catalisa.model.Turma;
import com.zup.catalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public Turma cadastrar(Turma turma) {

        return turmaRepository.save(turma);

    }

}

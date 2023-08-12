package com.zup.catalisa.service;

import com.zup.catalisa.model.Disciplina;
import com.zup.catalisa.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listar() {

        return disciplinaRepository.findAll();

    }
    public Optional<Disciplina> listarPorId(Long id) {

        return disciplinaRepository.findById(id);

    }

    public void excluir(Long id){

        disciplinaRepository.deleteById(id);

    }

    public Disciplina cadastrar(Disciplina disciplina) {

        return disciplinaRepository.save(disciplina);

    }

}

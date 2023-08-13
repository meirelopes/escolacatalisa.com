package com.zup.catalisa.service;

import com.zup.catalisa.model.Curso;
import com.zup.catalisa.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    public List<Curso> listar() {

        return cursoRepository.findAll();

    }
    public Optional<Curso> listarPorId(Long id) {

        return cursoRepository.findById(id);

    }

    public void excluir(Long id){

        cursoRepository.deleteById(id);

    }

    public Curso cadastrar(Curso curso) {

        return cursoRepository.save(curso);

    }

}

package com.zup.catalisa.service;

import com.zup.catalisa.model.Aluno;
import com.zup.catalisa.model.Disciplina;
import com.zup.catalisa.repository.AlunoRepository;
import com.zup.catalisa.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private DisciplinaService disciplinaService;

    public List<Aluno> listar() {

        return alunoRepository.findAll();

    }

    public Optional<Aluno> buscarPorId(Long id) {

        return alunoRepository.findById(id);

    }

    public void excluir(Long id) {

        alunoRepository.deleteById(id);

    }

    @Transactional
    public Aluno cadastrar(Aluno aluno) {

        aluno = alunoRepository.save(aluno);

        return buscarPorId(aluno.getId()).get();

    }

    public Aluno atualizarCurso(Long id, Aluno aluno) {

        return null;

    }

    public Disciplina adicionarDisciplina(Long disciplinaId, Long alunoId) {

        Disciplina disciplina = disciplinaService.listarPorId(disciplinaId).orElse(null);
        System.out.println(disciplina.getNome());

        Aluno aluno = buscarPorId(alunoId).orElse(null);

        List<Disciplina> lista = aluno.getDisciplinas();

        lista.add(disciplina);

        alunoRepository.save(aluno);

        return disciplina;

    }

}



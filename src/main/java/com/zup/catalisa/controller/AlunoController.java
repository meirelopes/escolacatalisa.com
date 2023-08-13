package com.zup.catalisa.controller;

import com.zup.catalisa.dto.saida.AlunoMatriculaDtoSaida;
import com.zup.catalisa.dto.entrada.AlunoMatriculaDtoEntrada;
import com.zup.catalisa.dto.saida.CursoDtoSaida;
import com.zup.catalisa.dto.saida.MatriculaDtoSaida;
import com.zup.catalisa.dto.saida.TurmaDtoSaida;
import com.zup.catalisa.model.*;
import com.zup.catalisa.service.AlunoService;
import com.zup.catalisa.service.MatriculaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Aluno> listar() {

        return alunoService.listar();

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        alunoService.excluir(id);

    }


    @PostMapping
    public AlunoMatriculaDtoSaida cadastrar(@RequestBody AlunoMatriculaDtoEntrada alunoDtoEntrada) {
        logger.debug("Iniciando cadastro de aluno...");

        Aluno aluno = new Aluno();

        // Preencher informações do aluno
        aluno.setNome(alunoDtoEntrada.getNome());
        aluno.setIdade(alunoDtoEntrada.getIdade());
        aluno.setCpf(alunoDtoEntrada.getCpf());
        aluno.setTelefone(alunoDtoEntrada.getTelefone());
        aluno.setEmail(alunoDtoEntrada.getEmail());

        // Preencher endereço
        Endereco endereco = new Endereco();
        endereco.setId(alunoDtoEntrada.getEnderecoIdDtoEntrada().getEnderecoId());
        aluno.setEndereco(endereco);

        // Preencher curso
        Curso curso = new Curso();
        curso.setId(alunoDtoEntrada.getCursoIdDtoEntrada().getCursoId());
        aluno.setCurso(curso);

        // Preencher turma
        Turma turma = new Turma();
        turma.setId(alunoDtoEntrada.getTurmaIdDtoEntrada().getTurmaId());
        aluno.setTurma(turma);

        // Criar matrícula com a data atual
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(LocalDate.now());
        matriculaService.salvarMatricula(matricula);
        aluno.setMatricula(matricula);


        // Chamar o serviço para cadastrar o aluno
        Aluno alunoSalvo = alunoService.cadastrar(aluno);




        AlunoMatriculaDtoSaida alunoMatriculaDtoSaida = getAlunoMatriculaDtoSaida(matricula, alunoSalvo);

        logger.debug("Aluno cadastrado com sucesso.");

        return alunoMatriculaDtoSaida;

    }

    private AlunoMatriculaDtoSaida getAlunoMatriculaDtoSaida(Matricula matricula, Aluno alunoSalvo) {
        // Converter para DTO de saída
        AlunoMatriculaDtoSaida alunoMatriculaDtoSaida = new AlunoMatriculaDtoSaida();

        alunoMatriculaDtoSaida.setId(alunoSalvo.getId());
        alunoMatriculaDtoSaida.setNome(alunoSalvo.getNome());

        // Preencher matrícula
        MatriculaDtoSaida matriculaDtoSaida = new MatriculaDtoSaida();
        matriculaDtoSaida.setId(matricula.getId());
        matriculaDtoSaida.setDataMatricula(matricula.getDataMatricula());
        alunoMatriculaDtoSaida.setMatricula(matriculaDtoSaida);

        // Preencher curso e turma
        CursoDtoSaida cursoDtoSaida = new CursoDtoSaida();
        cursoDtoSaida.setId(alunoSalvo.getCurso().getId());
        cursoDtoSaida.setNome(alunoSalvo.getCurso().getNome());
        alunoMatriculaDtoSaida.setCurso(cursoDtoSaida);

        TurmaDtoSaida turmaDtoSaida = new TurmaDtoSaida();
        turmaDtoSaida.setId(alunoSalvo.getTurma().getId());
        turmaDtoSaida.setNome(alunoSalvo.getTurma().getNome());
        alunoMatriculaDtoSaida.setTurma(turmaDtoSaida);

        return alunoMatriculaDtoSaida;

    }


}

package com.zup.catalisa.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.catalisa.api.assembler.TurmaModelAssembler;
import com.zup.catalisa.model.Aluno;
import com.zup.catalisa.model.Curso;
import com.zup.catalisa.model.Disciplina;
import com.zup.catalisa.model.Matricula;
import com.zup.catalisa.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class AlunoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    AlunoService alunoService;
    @MockBean
    MatriculaService matriculaService;
    @MockBean
    CursoService cursoService;
    @MockBean
    DisciplinaService disciplinaService;
    @MockBean
    EnderecoService enderecoService;
    @MockBean
    ProfessorService professorService;
    @MockBean
    TurmaService turmaService;
    @MockBean
    TurmaModelAssembler turmaModelAssembler;

    @Test
    public void deveRetornarStatusOkEUmaDisciplina_QuandoCadastrarUmaDisciplinaAUmAluno() throws Exception {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Engenharia Civil");
        curso.setCargaHoraria(3600);

        Matricula matricula = new Matricula();
        matricula.setDataMatricula(LocalDate.now());
        matricula.setId(1L);

        Aluno aluno = new Aluno();
        aluno.setNome("Jucemeire Marques Lopes");
        aluno.setCpf("00000000000");
        aluno.setCurso(curso);
        aluno.setMatricula(matricula);
        aluno.setId(1L);


        Disciplina disciplina = new Disciplina();
        disciplina.setId(1L);
        disciplina.setNome("Cálculo I");
        disciplina.setCargaHoraria(60);
        disciplina.setCurso(curso);

        Mockito.when(alunoService.adicionarDisciplina(1L, 1L)).thenReturn(disciplina);

        mockMvc.perform(MockMvcRequestBuilders.post("/alunos/adicionardisciplina/{disciplinaId}/{alunoId}", 1L, 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(disciplina.getId()))  // Verifica o ID retornado
                .andExpect(jsonPath("$.nome").value(disciplina.getNome()))  // Verifica o nome retornado
                .andExpect(jsonPath("$.cargaHoraria").value(disciplina.getCargaHoraria()))
                .andExpect(jsonPath("$.curso.id").value(disciplina.getCurso().getId()));
    }


}

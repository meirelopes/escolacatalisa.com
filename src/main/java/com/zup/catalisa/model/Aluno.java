package com.zup.catalisa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
1. Cadastro de alunos - OK
2. Cadastro de curso - OK
3. Cadastro de professor - OK
4. Listar todos os alunos - OK
5. Listar todos os professores - OK
6. Listar todos os cursos - OK
7. Atualizar curso do aluno
8. Deletar curso - OK
9. Deletar aluno - OK
10.Deletar professor - OK

Entidades:
1. Aluno: ID, nome, idade, e-mail.
2. Curso: ID, nome, carga horária.
3. Matrícula: ID, data da matrícula, aluno, curso.
4. Professor: ID, nome, idade, curso, salario.

DTOs:
1. AlunoDTO
2. CursoDTO
3. MatriculaDTO
4. ProfessorDTO
 */
@Entity
@Data
//@Embeddable
public class Aluno extends Pessoa {
    @OneToOne
    private Matricula matricula;
    @ManyToOne
    private Curso curso;
    @ManyToMany(mappedBy = "alunos")
    private List<Disciplina> disciplinas = new ArrayList<>();
    @ManyToOne
    //@JoinColumn(name = "turma_codigo")
    private Turma turma;

}

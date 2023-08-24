package com.zup.catalisa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Disciplina {

    @Id
    //@SequenceGenerator(name = "disciplina_idsequence", sequenceName = "disciplina_idsequence", allocationSize = 1) ////
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_idsequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Curso curso;
    private Integer cargaHoraria;
    @ManyToOne
    private Professor professor;
    @ManyToMany
    @JoinTable(name = "disciplinas_alunos", joinColumns = @JoinColumn(name = "disciplina_fk"),
    inverseJoinColumns = @JoinColumn(name = "aluno_fk"))

    private List<Aluno> alunos;

}

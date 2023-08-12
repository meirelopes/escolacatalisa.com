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
    private List<Aluno> alunos;

}

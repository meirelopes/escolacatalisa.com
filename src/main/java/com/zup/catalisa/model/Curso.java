package com.zup.catalisa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
2. Curso: ID, nome, carga horária, aluno.
 */
@Entity
@Data
public class Curso {
    @Id
    //@SequenceGenerator(name = "curso_idsequence", sequenceName = "curso_idsequence", allocationSize = 1) ////
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_idsequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @OneToMany
    private List<Professor> professores = new ArrayList<>();

    private Integer cargaHoraria;

    @JsonIgnore
    @OneToMany
    private List<Matricula> matriculas = new ArrayList<>();

}

package com.zup.catalisa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zup.catalisa.enumeracao.Turno;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Turma {
    @Id
   // @SequenceGenerator(name = "turma_idsequence", sequenceName = "turma_idsequence", allocationSize = 1) ////
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma_idsequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Turno turno;
    private String localizacao;
    @OneToMany(mappedBy = "turma")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();
    @ManyToOne//(cascade=CascadeType.ALL)
    private Curso curso;

}

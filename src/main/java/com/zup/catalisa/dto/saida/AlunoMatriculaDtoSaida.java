package com.zup.catalisa.dto.saida;

import com.zup.catalisa.model.Curso;
import com.zup.catalisa.model.Matricula;
import com.zup.catalisa.model.Turma;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class AlunoMatriculaDtoSaida {

    private Long id;
    private String nome;
    private MatriculaDtoSaida matricula;
    private CursoDtoSaida curso;
    private TurmaDtoSaida turma;




}

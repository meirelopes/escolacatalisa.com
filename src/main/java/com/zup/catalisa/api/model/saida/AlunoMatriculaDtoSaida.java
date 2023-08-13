package com.zup.catalisa.api.model.saida;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoMatriculaDtoSaida {

    private Long id;
    private String nome;
    private MatriculaDtoSaida matricula;
    private CursoModel curso;
    private TurmaModel turma;




}

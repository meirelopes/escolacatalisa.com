package com.zup.catalisa.api.model.saida;

import com.zup.catalisa.model.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaModel {

    private Long id;
    private String nome;
    private CursoModel curso;

}

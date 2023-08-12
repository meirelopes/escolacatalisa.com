package com.zup.catalisa.dto.entrada;

import com.zup.catalisa.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class AlunoMatriculaDtoEntrada {

    private Long id;
    private String nome;
    private String idade;
    private String cpf;
    private String telefone;
    private String email;
    private EnderecoIdDtoEntrada enderecoIdDtoEntrada;

    private CursoIdDtoEntrada cursoIdDtoEntrada;
    private TurmaIdDtoEntrada turmaIdDtoEntrada;
    private MatriculaDtoEntrada matriculaDto;

}


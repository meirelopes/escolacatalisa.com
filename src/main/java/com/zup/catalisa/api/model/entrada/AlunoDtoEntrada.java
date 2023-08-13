package com.zup.catalisa.api.model.entrada;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AlunoDtoEntrada {

    private Long id;
    @NotNull
    private String nome;
    private String idade;
    private String cpf;
    private String telefone;
    private String email;
    private EnderecoIdDtoEntrada enderecoIdDtoEntrada;

    private CursoDtoEntrada cursoIdDtoEntrada;
    private TurmaDtoEntrada turmaIdDtoEntrada;
    private MatriculaDtoEntrada matriculaDto;

}


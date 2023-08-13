package com.zup.catalisa.dto.saida;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class ProfessorDtoSaida {

    private Long id;
    private String nome;
    private String email;

}

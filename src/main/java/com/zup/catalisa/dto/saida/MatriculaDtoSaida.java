package com.zup.catalisa.dto.saida;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Getter
@Setter
public class MatriculaDtoSaida {

    private Long id;
    private LocalDate dataMatricula;

}

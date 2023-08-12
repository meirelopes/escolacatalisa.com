package com.zup.catalisa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {
    @Id
    //@SequenceGenerator(name = "endereco_idsequence", sequenceName = "endereco_idsequence", allocationSize = 1) ////
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_idsequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
}

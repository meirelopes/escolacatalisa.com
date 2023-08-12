package com.zup.catalisa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
/*
1. Pessoa: ID, nome, idade, e-mail.

 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public  class Pessoa {
    //@Embedded
    //@SequenceGenerator(name = "pessoa_idsequence", sequenceName = "pessoa_idsequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_idsequence")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // Use GenerationType.TABLE
    private Long id;
    @Column(name = "nome_completo")
    //@Embedded
    private String nome;
    //@Embedded
    private String idade;
    //@Embedded
    private String cpf;
    //@Embedded
    private String telefone;
   // @Embedded
    private String email;
   // @Embedded
    @JsonIgnore
    @OneToOne
    private Endereco endereco;

}

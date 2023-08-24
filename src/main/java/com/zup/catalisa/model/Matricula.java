package com.zup.catalisa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

//3. Matrícula: ID, data da matrícula, aluno, curso.
@Entity
@Data
public class Matricula {
    @Id
   // @SequenceGenerator(name = "matricula_idsequence", sequenceName = "matricula_idsequence", allocationSize = 1) ////
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_idsequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataMatricula;

}

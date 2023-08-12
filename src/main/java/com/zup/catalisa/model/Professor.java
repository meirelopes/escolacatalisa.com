package com.zup.catalisa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//4. Professor: ID, nome, idade, curso, salario.

@Entity
@Data
//@Embeddable
public class Professor extends Pessoa {

    @OneToMany
    @JsonIgnore
    private List<Disciplina> disciplinas = new ArrayList<>();;
    private BigDecimal salario;


}

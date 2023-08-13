package com.zup.catalisa.api.assembler;

import com.zup.catalisa.api.model.saida.TurmaModel;
import com.zup.catalisa.model.Turma;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TurmaModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public TurmaModel toModel(Turma turma) {

        return modelMapper.map(turma, TurmaModel.class);

    }

}

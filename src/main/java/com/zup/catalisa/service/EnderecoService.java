package com.zup.catalisa.service;

import com.zup.catalisa.model.Endereco;
import com.zup.catalisa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listar() {

        return enderecoRepository.findAll();

    }

    public Endereco cadastrar(Endereco endereco) {

        return enderecoRepository.save(endereco);

    }

}

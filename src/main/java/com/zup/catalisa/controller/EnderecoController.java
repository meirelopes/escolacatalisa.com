package com.zup.catalisa.controller;

import com.zup.catalisa.model.Endereco;
import com.zup.catalisa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listar() {

        return enderecoService.listar();

    }

    @PostMapping
    public Endereco cadastrar(@RequestBody Endereco endereco) {

        return enderecoService.cadastrar(endereco);

    }
}

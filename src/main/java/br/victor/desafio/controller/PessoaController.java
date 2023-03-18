package br.victor.desafio.controller;

import br.victor.desafio.entity.PessoaEntity;
import br.victor.desafio.request.PessoaRequest;
import br.victor.desafio.service.IPessoaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/pessoa")
@RequiredArgsConstructor
@ApiOperation(value = "Retorna produtos elegiveis do cliente.")
public class PessoaController {

    private final IPessoaService service;

    @PostMapping
    public PessoaEntity cadastro(@RequestBody @Valid PessoaRequest request) {
        return service.cadastroDePessoa(request);
    }

    @GetMapping("{nome}")
    public PessoaEntity buscarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }
}

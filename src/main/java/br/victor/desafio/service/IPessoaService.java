package br.victor.desafio.service;

import br.victor.desafio.entity.PessoaEntity;
import br.victor.desafio.request.PessoaRequest;

public interface IPessoaService {

    PessoaEntity cadastroDePessoa(PessoaRequest request);


    PessoaEntity buscarPorNome(String nome);
}

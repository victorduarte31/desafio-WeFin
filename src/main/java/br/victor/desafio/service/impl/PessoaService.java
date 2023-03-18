package br.victor.desafio.service.impl;

import br.victor.desafio.entity.PessoaEntity;
import br.victor.desafio.repository.PessoaRepository;
import br.victor.desafio.request.PessoaRequest;
import br.victor.desafio.service.IPessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class PessoaService implements IPessoaService {

    private final PessoaRepository repository;

    @Override
    public PessoaEntity cadastroDePessoa(PessoaRequest request) {

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(request.getNome());
        pessoaEntity.setIdenficador(request.getIdenficador());
        pessoaEntity.setTipoIdentificador(request.getTipoIdentificador().getDescricao());

        return repository.save(pessoaEntity);
    }

    @Override
    public PessoaEntity buscarPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não existe cadastrada na base de dados."));
    }
}

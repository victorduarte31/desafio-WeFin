package br.victor.desafio.repository;

import br.victor.desafio.entity.PessoaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PessoaRepository extends MongoRepository<PessoaEntity, String> {

    Optional<PessoaEntity> findByNome(String nome);

}

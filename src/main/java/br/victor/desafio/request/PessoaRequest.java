package br.victor.desafio.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class PessoaRequest {

    @NotNull(message = "Nome é obrigatorio.")
    private String nome;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups =  CnpjGroup.class)
    @NotBlank(message = "idenficador é obrigatorio.")
    private String idenficador;
    @NotNull(message = "tipoIdentificador é obrigatorio.")
    private TipoIdentificadorEnum tipoIdentificador;
}

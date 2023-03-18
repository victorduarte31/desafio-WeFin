package br.victor.desafio.request;

import lombok.Getter;

@Getter
public enum TipoIdentificadorEnum {

    CPF(1, "CPF", CpfGroup.class),
    CNPJ(2, "CNPJ", CnpjGroup.class);

    private final int codigo;
    private final String descricao;
    private final Class<?> group;

    TipoIdentificadorEnum(int codigo, String descricao, Class<?> group) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.group = group;
    }
}

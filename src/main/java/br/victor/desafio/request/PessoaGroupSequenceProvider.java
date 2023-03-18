package br.victor.desafio.request;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class PessoaGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaRequest> {


    @Override
    public List<Class<?>> getValidationGroups(PessoaRequest request) {

        List<Class<?>> groups = new ArrayList<>();
        groups.add(PessoaRequest.class);

        if (check(request)) {
            groups.add(request.getTipoIdentificador().getGroup());
        }

        return groups;
    }

    protected boolean check(PessoaRequest request) {
        return request != null && request.getTipoIdentificador() != null;
    }
}

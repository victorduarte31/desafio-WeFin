package br.victor.desafio.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class ApiErrors {

    List<String> errorsApi;
    public ApiErrors(String message) {
        this.errorsApi = Collections.singletonList(message);
    }
}

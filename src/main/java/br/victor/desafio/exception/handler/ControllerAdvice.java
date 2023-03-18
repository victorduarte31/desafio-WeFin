package br.victor.desafio.exception.handler;

import br.victor.desafio.exception.CnpjValidatorException;
import br.victor.desafio.exception.CpfValidatorException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException e) {
        var bindingResult = e.getBindingResult();
        List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new ApiErrors(errors);
    }

    @ExceptionHandler(CnpjValidatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handleValidationErrors(CnpjValidatorException ex) {
        String mensagemErro = ex.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity<>(apiErrors, status);
    }

    @ExceptionHandler(CpfValidatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handleValidationErrors(CpfValidatorException ex) {
        String mensagemErro = ex.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity<>(apiErrors, status);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException ex) {
        String mensagemErro = ex.getReason();
        HttpStatus status = ex.getStatus();
        var apiErrors = new ApiErrors(mensagemErro);

        return new ResponseEntity<>(apiErrors, status);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(HttpMessageNotReadableException ex) {
        String mensagemErro = "Tipo de identificador invalido";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var apiErrors = new ApiErrors(mensagemErro);

        return new ResponseEntity<>(apiErrors, status);
    }
}

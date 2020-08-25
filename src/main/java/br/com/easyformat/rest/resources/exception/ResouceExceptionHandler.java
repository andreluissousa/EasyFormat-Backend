package br.com.easyformat.rest.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.easyformat.rest.ApiErrors;
import br.com.easyformat.service.exception.ObjectNotFoundException;

@RestControllerAdvice
public class ResouceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerRegraNegocioException(ObjectNotFoundException ex){
        String menssagemErro = ex.getMessage();
        return new ApiErrors(menssagemErro);
    }
}
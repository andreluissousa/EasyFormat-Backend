package br.com.easyformat.rest.resources.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.easyformat.rest.ApiErrors;
import br.com.easyformat.service.exception.ObjectNotFoundException;
import br.com.easyformat.service.exception.RegraNegocioException;

@RestControllerAdvice
public class ResouceExceptionHandler {
    
    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex){
        String menssagemErro = ex.getMessage();
        return new ApiErrors(menssagemErro);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlerObjectNotFoundException(ObjectNotFoundException ex){
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors hadlerMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .map( erro -> erro.getDefaultMessage())
            .collect(Collectors.toList());
        return new ApiErrors(errors);
    }
}
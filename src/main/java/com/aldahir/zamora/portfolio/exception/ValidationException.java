package com.aldahir.zamora.portfolio.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends RuntimeException {
    private final BindingResult bindingResult;
    public ValidationException(BindingResult bindingResult) {
        super("Se ha producido un error al validar el registro: "+bindingResult.getErrorCount());
        this.bindingResult = bindingResult;
    }
}

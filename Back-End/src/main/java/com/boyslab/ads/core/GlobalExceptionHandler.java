package com.boyslab.ads.core;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.ErrorDataResult;
import com.boyslab.ads.core.result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult businessExceptionHandler(BusinessException exception){

        return  new ErrorResult(exception.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Map<String,String>> handleExceptionValidationRequest(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors= new HashMap<>();
        ErrorDataResult<Map<String,String>> error= new ErrorDataResult<>("validation rules",validationErrors);
        if (!exception.getFieldErrors().isEmpty()){
            for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        if (!exception.getGlobalErrors().isEmpty()){
            for (ObjectError objectError: exception.getBindingResult().getGlobalErrors()){
                validationErrors.put(objectError.getObjectName(),objectError.getDefaultMessage());
            }
        }
        error.setData(validationErrors);
        return error;
    }

}

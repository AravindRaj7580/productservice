package com.Aravind.productservice.Exceptions;

import com.Aravind.productservice.DTOs.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TestException.class)
    public ResponseEntity<ExceptionDTO> returnTestException(){
        return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND,"Testing exception"), HttpStatus.BAD_REQUEST);
    }

}

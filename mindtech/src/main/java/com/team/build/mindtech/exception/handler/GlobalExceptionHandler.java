package com.team.build.mindtech.exception.handler;

import com.team.build.mindtech.exception.error.ApiErro;
import com.team.build.mindtech.exception.error.CampoDetalheErro;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErro> handleValidation(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<CampoDetalheErro> detalhes = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new CampoDetalheErro(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();
        ApiErro apiErro = new ApiErro(
                 "Erro de validação nos campos enviados", detalhes, request.getRequestURI(), LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErro);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErro> handleException(Exception e, HttpServletRequest request) {
        ApiErro apiErro = new ApiErro(
                "Ocorreu um erro inesperado",
                null,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErro);
    }

}

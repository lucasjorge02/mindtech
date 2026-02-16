package com.team.build.mindtech.infrastructure.handler;

import com.team.build.mindtech.domain.exception.ErrorException;
import com.team.build.mindtech.domain.exception.FieldErrorDetail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔹 Bean Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorException> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<FieldErrorDetail> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorDetail(
                        error.getField(),
                        error.getDefaultMessage()))
                .toList();

        ErrorException errorException = new ErrorException(
                "ValidationError",
                "Erro de validação nos campos enviados",
                details,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorException);
    }


    // 🔹 Erro genérico (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorException> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        ErrorException errorException = new ErrorException(
                "InternalServerError",
                "Ocorreu um erro inesperado",
                null,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorException);
    }
}
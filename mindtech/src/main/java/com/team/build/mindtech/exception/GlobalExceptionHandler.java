package com.team.build.mindtech.exception;

import com.team.build.mindtech.dto.response.FieldErrorResponse;
import com.team.build.mindtech.components.ConstraintExtractor;
import com.team.build.mindtech.components.ConstraintTranslator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ConstraintExtractor extractor;
    private final ConstraintTranslator translator;

    public GlobalExceptionHandler(ConstraintExtractor extractor, ConstraintTranslator translator) {
        this.extractor = extractor;
        this.translator = translator;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorResponse>> handleBeanValidation(
            MethodArgumentNotValidException ex) {

        List<FieldErrorResponse> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponse(
                        error.getField(),
                        error.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(details);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<FieldErrorResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

        FieldErrorResponse detail = extractor.extract(ex)
                .map(translator::translate)
                .orElse(new FieldErrorResponse(
                "unknown",
             "Erro na interação com o banco de dados."
                ));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(detail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
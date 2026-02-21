package com.team.build.mindtech.exception.handler;

import com.team.build.mindtech.exception.error.ApiError;
import com.team.build.mindtech.exception.error.FieldErrorDetail;
import com.team.build.mindtech.exception.extractor.ConstraintExtractor;
import com.team.build.mindtech.exception.translator.ConstraintTranslator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ConstraintExtractor extractor;
    private ConstraintTranslator translator;

    public GlobalExceptionHandler(ConstraintExtractor extractor, ConstraintTranslator translator) {
        this.extractor = extractor;
        this.translator = translator;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleBeanValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<FieldErrorDetail> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorDetail(
                        error.getField(),
                        error.getDefaultMessage()))
                .toList();

        ApiError apiError = new ApiError(
                "Erro de validação nos campos enviados",
                details,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolation(
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

        FieldErrorDetail detail = extractor.extract(ex)
                .map(translator::translate)
                .orElse(new FieldErrorDetail(
                        "unknown",
                        "Erro de integridade de dados"
                ));

        ApiError apiError = new ApiError(
                "Violação de integridade de dados",
                List.of(detail),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        ApiError apiError = new ApiError(
                "Ocorreu um erro inesperado",
                null,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiError);
    }
}
package com.team.build.mindtech.exception;

import com.team.build.mindtech.exception.bussiness.EmailCadastradoException;
import com.team.build.mindtech.exception.bussiness.InvalidCredentialsException;
import com.team.build.mindtech.components.RestricaoExtractor;
import com.team.build.mindtech.components.TradutorPadraoContraintError;
import com.team.build.mindtech.dto.response.CampoDetalheErroResponse;
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

    private final TradutorPadraoContraintError tradutor;
    private final RestricaoExtractor extractor;

    public GlobalExceptionHandler(TradutorPadraoContraintError tradutor, RestricaoExtractor extractor) {
        this.tradutor = tradutor;
        this.extractor = extractor;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<CampoDetalheErroResponse>> handleValidation(MethodArgumentNotValidException e) {

        List<CampoDetalheErroResponse> detalhes = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new CampoDetalheErroResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detalhes);
    }

    @ExceptionHandler(EmailCadastradoException.class)
    public ResponseEntity<CampoDetalheErroResponse> handleEmailCadastrado(EmailCadastradoException e) {
        CampoDetalheErroResponse erro = new CampoDetalheErroResponse(
                "Email", e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<CampoDetalheErroResponse> handleInvalidCredentials(InvalidCredentialsException e) {
        CampoDetalheErroResponse erro = new CampoDetalheErroResponse(
                "Email ou senha", e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

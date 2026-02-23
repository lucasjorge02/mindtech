package com.team.build.mindtech.exception.translator;

import com.team.build.mindtech.exception.error.CampoDetalheErro;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TradutorPadraoContraintError {
    private final Map<String, CampoDetalheErro> CONSTRAINTS = Map.of(
            "uk_email",
            new CampoDetalheErro("email" , "usuario ja cadastrado")
    );
    public CampoDetalheErro traduzir(String constraintName) {
        return CONSTRAINTS.get(constraintName);
    }
}

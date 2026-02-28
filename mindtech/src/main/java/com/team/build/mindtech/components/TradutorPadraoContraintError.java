package com.team.build.mindtech.components;

import com.team.build.mindtech.dto.response.CampoDetalheErroResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TradutorPadraoContraintError {
    private final Map<String, CampoDetalheErroResponse> CONSTRAINTS = Map.of(
            "uk_email",
            new CampoDetalheErroResponse("email" , "usuario ja cadastrado")
    );
    public CampoDetalheErroResponse traduzir(String constraintName) {
        return CONSTRAINTS.get(constraintName);
    }
}

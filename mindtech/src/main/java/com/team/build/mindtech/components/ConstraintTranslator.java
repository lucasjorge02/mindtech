package com.team.build.mindtech.components;

import com.team.build.mindtech.dto.response.FieldErrorResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConstraintTranslator {

    private final Map<String, FieldErrorResponse> constraintMap = Map.of(
            "uk_email", new FieldErrorResponse("email", "Email já cadastrado")
    );

    public FieldErrorResponse translate(String constraint) {

        return constraintMap.get(constraint);
    }
}

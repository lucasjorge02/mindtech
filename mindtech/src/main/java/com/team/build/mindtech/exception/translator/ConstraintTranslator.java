package com.team.build.mindtech.exception.translator;

import com.team.build.mindtech.exception.error.FieldErrorDetail;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConstraintTranslator {

    private final Map<String, FieldErrorDetail> constraintMap = Map.of(
            "uk_email", new FieldErrorDetail("email", "Email já cadastrado")
    );

    public FieldErrorDetail translate(String constraint) {

        return constraintMap.getOrDefault(
                constraint,
                new FieldErrorDetail("unknown", "Violação de regra de integridade")
        );
    }
}

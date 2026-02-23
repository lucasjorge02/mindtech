package com.team.build.mindtech.exception.extractor;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestricaoExtractor {

    public Optional<String> extract(DataIntegrityViolationException ex) {

        return findCause(ex, ConstraintViolationException.class)
                .map(ConstraintViolationException::getConstraintName)
                .map(this::normalize);
    }

    private String normalize(String name) {
        return name.substring(name.lastIndexOf('.') + 1)
                .toLowerCase();
    }

    private <T extends Throwable> Optional<T> findCause(
            Throwable ex,
            Class<T> type
    ) {
        Throwable cause = ex;

        while (cause != null) {
            if (type.isInstance(cause)) {
                return Optional.of(type.cast(cause));
            }
            cause = cause.getCause();
        }

        return Optional.empty();
    }
}

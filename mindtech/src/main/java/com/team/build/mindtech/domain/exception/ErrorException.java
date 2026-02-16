package com.team.build.mindtech.domain.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorException(
        String error,
        String message,
        List<FieldErrorDetail> details,
        String path,
        LocalDateTime timestamp
) {
}

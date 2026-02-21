package com.team.build.mindtech.exception.error;

import java.time.LocalDateTime;
import java.util.List;

public record ApiError(
        String message,
        List<FieldErrorDetail> details,
        String path,
        LocalDateTime timestamp
) {
}

package com.cortexplatform.common.error;

import java.util.Map;
import java.util.Objects;

/**
 * Standard domain error representation.
 * Used for APIs, events and logging.
 */
public record DomainError(
        String code,
        String message,
        Map<String, Object> metadata
) {

    public DomainError {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(message, "message must not be null");

        if (code.isBlank()) {
            throw new IllegalArgumentException("code must not be blank");
        }
        if (message.isBlank()) {
            throw new IllegalArgumentException("message must not be blank");
        }
    }

    public static DomainError of(String code, String message) {
        return new DomainError(code, message, Map.of());
    }
}

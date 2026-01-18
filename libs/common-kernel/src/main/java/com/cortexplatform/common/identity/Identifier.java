package com.cortexplatform.common.identity;

import java.util.Objects;
import java.util.UUID;

/**
 * Generic identifier value object.
 * Use it to avoid passing raw Strings everywhere.
 */
public record Identifier(String value) {

    public Identifier {
        Objects.requireNonNull(value, "value must not be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("value must not be blank");
        }
    }

    public static Identifier random() {
        return new Identifier(UUID.randomUUID().toString());
    }
}

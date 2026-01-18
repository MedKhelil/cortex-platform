package com.cortexplatform.common.events;

import com.cortexplatform.common.identity.Identifier;

import java.time.Instant;
import java.util.Objects;

/**
 * Metadata shared by all domain events.
 * Represents causality, correlation and temporal context.
 */
public record DomainEventMetadata(
        Identifier eventId,
        String eventType,
        int eventVersion,
        Identifier correlationId,
        Identifier causationId,
        Instant occurredAt
) {

    public DomainEventMetadata {
        Objects.requireNonNull(eventId, "eventId must not be null");
        Objects.requireNonNull(eventType, "eventType must not be null");
        Objects.requireNonNull(correlationId, "correlationId must not be null");
        Objects.requireNonNull(occurredAt, "occurredAt must not be null");

        if (eventType.isBlank()) {
            throw new IllegalArgumentException("eventType must not be blank");
        }

        if (eventVersion <= 0) {
            throw new IllegalArgumentException("eventVersion must be positive");
        }
    }

    public static DomainEventMetadata now(
            String eventType,
            int eventVersion,
            Identifier correlationId,
            Identifier causationId
    ) {
        return new DomainEventMetadata(
                Identifier.random(),
                eventType,
                eventVersion,
                correlationId,
                causationId,
                Instant.now()
        );
    }
}

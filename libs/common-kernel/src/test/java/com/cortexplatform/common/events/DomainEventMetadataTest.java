package com.cortexplatform.common.events;

import com.cortexplatform.common.identity.Identifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DomainEventMetadataTest {

    @Test
    void shouldCreateValidMetadata() {
        Identifier correlationId = Identifier.random();

        DomainEventMetadata metadata =
                DomainEventMetadata.now("TestEvent", 1, correlationId, null);

        assertThat(metadata.eventId()).isNotNull();
        assertThat(metadata.eventType()).isEqualTo("TestEvent");
        assertThat(metadata.eventVersion()).isEqualTo(1);
        assertThat(metadata.correlationId()).isEqualTo(correlationId);
        assertThat(metadata.occurredAt()).isNotNull();
    }
}

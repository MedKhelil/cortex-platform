package com.cortexplatform.stimulusgateway.adapters.out.publisher;

import com.cortexplatform.common.events.DomainEventMetadata;
import com.cortexplatform.stimulusgateway.application.ports.out.StimulusEventPublisherPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogStimulusEventPublisherAdapter implements StimulusEventPublisherPort {

    private static final Logger log = LoggerFactory.getLogger(LogStimulusEventPublisherAdapter.class);

    @Override
    public void publish(DomainEventMetadata metadata) {
        log.info("Publishing stimulus event: eventId={}, type={}, version={}, correlationId={}",
                metadata.eventId().value(),
                metadata.eventType(),
                metadata.eventVersion(),
                metadata.correlationId().value()
        );
    }
}

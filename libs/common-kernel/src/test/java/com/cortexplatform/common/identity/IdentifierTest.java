package com.cortexplatform.common.identity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IdentifierTest {

    @Test
    void shouldRejectNull() {
        assertThatThrownBy(() -> new Identifier(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldRejectBlank() {
        assertThatThrownBy(() -> new Identifier("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void randomShouldGenerateNonBlankValue() {
        Identifier id = Identifier.random();
        assertThat(id.value()).isNotBlank();
    }
}

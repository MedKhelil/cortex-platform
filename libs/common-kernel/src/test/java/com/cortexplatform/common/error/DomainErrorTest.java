package com.cortexplatform.common.error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DomainErrorTest {

    @Test
    void shouldCreateValidError() {
        DomainError error = DomainError.of("TEST_ERROR", "Something went wrong");

        assertThat(error.code()).isEqualTo("TEST_ERROR");
        assertThat(error.message()).isEqualTo("Something went wrong");
        assertThat(error.metadata()).isEmpty();
    }

    @Test
    void shouldRejectBlankCode() {
        assertThatThrownBy(() -> DomainError.of(" ", "msg"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

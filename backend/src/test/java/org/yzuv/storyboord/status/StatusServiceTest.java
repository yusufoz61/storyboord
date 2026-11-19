package org.yzuv.storyboord.status;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatusServiceTest {

    private final StatusService service = new StatusService();

    @Test
    void returnsUpWhenDatabaseIsUp() {
        assertEquals("UP", service.statusFor(true));
    }

    @Test
    void returnsDegradedWhenDatabaseIsDown() {
        assertEquals("DEGRADED", service.statusFor(false));
    }
}

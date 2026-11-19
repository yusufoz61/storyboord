package org.yzuv.storyboord.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// Spring Boot 4: if this import is red, let IntelliJ import AutoConfigureMockMvc
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@Tag("integration")
@SpringBootTest
@AutoConfigureMockMvc
class HealthControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthEndpointIsPublicAndReturnsUp() throws Exception {
        mockMvc.perform(get("/api/health"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void otherEndpointsNeedLogin() throws Exception {
        mockMvc.perform(get("/api/anything-else"))
            .andExpect(status().isUnauthorized());
    }
}

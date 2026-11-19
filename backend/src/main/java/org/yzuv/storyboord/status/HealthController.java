package org.yzuv.storyboord.status;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final StatusService statusService;

    public HealthController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", statusService.statusFor(true));
    }
}

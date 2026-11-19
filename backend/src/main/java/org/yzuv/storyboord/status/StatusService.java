package org.yzuv.storyboord.status;

import org.springframework.stereotype.Service;

@Service
public class StatusService {

    public String statusFor(boolean databaseUp) {
        return databaseUp ? "UP" : "DEGRADED";
    }
}

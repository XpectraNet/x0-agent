package org.xpectranet.x0.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insight")
public class InsightController {
    
    @PostMapping("/mint")
    public String mint(@RequestBody String insightJson) {
        return "Minted insight: " + insightJson;
    }
}

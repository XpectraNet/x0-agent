package com.xpectranet.x0.api;

import org.springframework.web.bind.annotation.*;
import com.xpectranet.x0.model.Insight;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/insight")
public class InsightController {

    @PostMapping("/mint")
    public ResponseEntity<String> mintInsight(@RequestBody Insight insight) {
        // Placeholder logic for minting
        return ResponseEntity.ok("Insight minted: " + insight.getContent());
    }
}
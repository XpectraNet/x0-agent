package com.xpectranet.x0.api;

import com.xpectranet.x0.model.Insight;
import com.xpectranet.x0.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * REST controller to handle insight-related requests:
 * minting, remixing, and validating.
 */
@RestController
@RequestMapping("/api/insight")
public class InsightController {

    private final InsightService insightService;

    @Autowired
    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    @PostMapping("/mint")
    public ResponseEntity<String> mintInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.mintInsight(insight));
    }

    @PostMapping("/remix")
    public ResponseEntity<String> remixInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.remixInsight(insight));
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.validateInsight(insight));
    }
}
package com.xpectranet.x0.api;

import com.xpectranet.x0.model.Insight;
import com.xpectranet.x0.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
        String result = insightService.mintInsight(insight);
        return ResponseEntity.ok(result);
    }
}
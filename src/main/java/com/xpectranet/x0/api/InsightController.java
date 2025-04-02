package com.xpectranet.x0.api;

import com.xpectranet.x0.model.Insight;
import com.xpectranet.x0.service.InsightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * REST controller to handle insight-related requests.
 */
@RestController
@RequestMapping("/api/insight")
@Tag(name = "Insight API", description = "Endpoints for minting, remixing, and validating insights")
public class InsightController {

    private final InsightService insightService;

    @Autowired
    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    @PostMapping("/mint")
    @Operation(summary = "Mint a new insight", description = "Create a new insight and anchor it into the memory graph")
    public ResponseEntity<String> mintInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.mintInsight(insight));
    }

    @PostMapping("/remix")
    @Operation(summary = "Remix an insight", description = "Modify or transform an existing insight into a new variation")
    public ResponseEntity<String> remixInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.remixInsight(insight));
    }

    @PostMapping("/validate")
    @Operation(summary = "Validate an insight", description = "Submit an insight to be validated and staked by a validator")
    public ResponseEntity<String> validateInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.validateInsight(insight));
    }
}
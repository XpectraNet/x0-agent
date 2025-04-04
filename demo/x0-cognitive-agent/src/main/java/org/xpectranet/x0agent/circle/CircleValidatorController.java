package org.xpectranet.x0agent.circle;

import org.springframework.web.bind.annotation.*;
import org.xpectranet.x0agent.validator.RemixValidationService;

import java.util.Map;
import java.util.HashMap;

/**
 * Circle Validator REST endpoint to validate remix requests between agents using symbolic rules.
 */
@RestController
@RequestMapping("/circle")
public class CircleValidatorController {

    private final RemixValidationService validator = new RemixValidationService();

    /**
     * POST /circle/validateRemix
     * Validates symbolic remix based on insight layer, origin type, and contract.
     */
    @PostMapping("/validateRemix")
    public Map<String, Object> validateRemix(@RequestBody Map<String, Object> request) {
        Map<String, String> insight = (Map<String, String>) request.get("targetInsight");

        String sourceLayer = insight.get("layer");
        String originType = insight.get("originType");
        String remixContract = insight.get("remixContract");
        String proposedLayer = (String) request.get("proposedLayer");

        boolean allowed = validator.isRemixAllowed(sourceLayer, proposedLayer, remixContract, originType);

        Map<String, Object> response = new HashMap<>();
        response.put("verdict", allowed ? "allowed" : "denied");
        response.put("reason", allowed
                ? sourceLayer + " → " + proposedLayer + " with contract: " + remixContract
                : "Symbolic rule violation or closed remix contract");
        response.put("signedBy", "Circle:Validator-1");

        return response;
    }
}
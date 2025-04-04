package org.xpectranet.x0agent.validator;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Service that validates proposed insight remix actions using symbolic logic from the XKO protocol.
 */
public class RemixValidationService {

    // Define symbolic remix rules by allowed layer transitions
    private static final Map<String, Set<String>> VALID_LAYER_REMIX = new HashMap<>();

    static {
        // From → To mapping (e.g., can remix L3 into L4)
        VALID_LAYER_REMIX.put("L3", Set.of("L4"));
        VALID_LAYER_REMIX.put("L2", Set.of("L4", "L5"));  // example symbolic expansion
    }

    /**
     * Validates whether a remix from source to target layer is allowed.
     * @param sourceLayer the origin layer of the insight
     * @param targetLayer the proposed remix layer
     * @param remixContract remix permission string (e.g., "open", "restricted")
     * @param originType the insight's origin type (X-, A-, T-, S-Insight)
     * @return true if remix is permitted under XKO logic, false otherwise
     */
    public boolean isRemixAllowed(String sourceLayer, String targetLayer, String remixContract, String originType) {
        // Remix must be contractually open
        if (!"open".equalsIgnoreCase(remixContract)) return false;

        // Cannot remix silent (S-) insights directly
        if ("S-Insight".equalsIgnoreCase(originType)) return false;

        // Layer path must be explicitly permitted
        Set<String> allowedTargets = VALID_LAYER_REMIX.getOrDefault(sourceLayer, Set.of());
        return allowedTargets.contains(targetLayer);
    }

    /**
     * Sample invocation
     */
    public static void main(String[] args) {
        RemixValidationService validator = new RemixValidationService();

        boolean result = validator.isRemixAllowed("L3", "L4", "open", "A-Insight");
        System.out.println("✓ L3 → L4 remix (open, A-Insight): " + (result ? "ALLOWED" : "DENIED"));

        boolean fail = validator.isRemixAllowed("L1", "L4", "open", "X-Insight");
        System.out.println("✗ L1 → L4 remix: " + (fail ? "ALLOWED" : "DENIED"));
    }
}
package org.xpectranet.x0.symbolic;

import java.util.Set;

public class EmotionValidator {
    private static final Set<String> VALID_EMOTIONS = Set.of("HOPE", "GRIEF", "AWE", "DOUBT");

    public static boolean isValidForLayer(String emotion, int layer) {
        return switch (layer) {
            case 3 -> emotion.equals("HOPE") || emotion.equals("GRIEF");
            case 4 -> emotion.equals("AWE");
            default -> false;
        };
    }
}
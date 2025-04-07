package org.xpectranet.x0.symbolic;

import java.util.UUID;

public class GlyphEngine {
    public static String generateGlyph(String agentId, String insightTrail) {
        return "glyph-" + UUID.nameUUIDFromBytes((agentId + insightTrail).getBytes());
    }

    public static String versionGlyph(String previousGlyph) {
        return previousGlyph + "-v" + System.currentTimeMillis();
    }
}
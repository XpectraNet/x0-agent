package org.xpectranet.x0agent.demo;

import java.util.*;

/**
 * CognitiveAgent simulates a memory-driven symbolic agent aligned with the XPECTRANET protocol.
 * Each agent can mint, reflect on, and remix symbolic insights across defined cognitive layers (L0–L4).
 */
public class CognitiveAgent {

    private final String name;

    // Internal symbolic memory trail — list of insights
    final List<Insight> memory = new ArrayList<>();

    /**
     * Constructs a new agent with a given symbolic name.
     * @param name The name of the cognitive agent
     */
    public CognitiveAgent(String name) {
        this.name = name;
    }

    /**
     * Mint a new symbolic insight into memory.
     * @param content     The symbolic content (thought, idea, trace)
     * @param layer       The cognitive layer (e.g., L0, L2, L4)
     * @param originType  The provenance tag (e.g., X-Insight, A-Insight)
     */
    public void mintInsight(String content, String layer, String originType) {
        Insight i = new Insight(content, layer, originType);
        memory.add(i);
        System.out.println(name + " minted insight: " + i);
    }

    /**
     * Reflect on L2-level insights — mimics symbolic internalization or recursive thought.
     */
    public void reflect() {
        System.out.println(name + " is reflecting...");
        for (Insight i : memory) {
            if ("L2".equals(i.layer)) {
                System.out.println("Reflecting on: " + i.content);
            }
        }
    }

    /**
     * Remix eligible insights from another agent (only L3 allowed → creates L4).
     * @param other Another cognitive agent to remix from
     */
    public void remixWith(CognitiveAgent other) {
        System.out.println(name + " is remixing with " + other.name);
        for (Insight otherInsight : other.memory) {
            if ("L3".equals(otherInsight.layer)) {
                // Construct a new remixed symbolic insight
                String remixed = "[REMIX] " + otherInsight.content + " + " + name;
                this.mintInsight(remixed, "L4", "A-Insight");
            }
        }
    }

    /**
     * Entry point for running the cognitive agent demo.
     */
    public static void main(String[] args) {
        CognitiveAgent agentA = new CognitiveAgent("Agent-A");
        CognitiveAgent agentB = new CognitiveAgent("Agent-B");

        // Agent A mints a symbolic trail
        agentA.mintInsight("Initial memory spark", "L0", "X-Insight");
        agentA.mintInsight("Pattern detected", "L1", "A-Insight");
        agentA.mintInsight("Internal critique: contradiction noted", "L2", "A-Insight");

        // Agent B contributes a divergent memory
        agentB.mintInsight("Intentional deviation", "L3", "A-Insight");

        // Agent A reflects internally and then remixes Agent B's divergent trail
        agentA.reflect();
        agentA.remixWith(agentB);
    }

    /**
     * Insight class represents a symbolic unit of cognition — tagged by layer and origin.
     */
    static class Insight {
        String content;
        String layer;
        String originType;

        public Insight(String content, String layer, String originType) {
            this.content = content;
            this.layer = layer;
            this.originType = originType;
        }

        @Override
        public String toString() {
            return "[" + layer + "] " + content + " (" + originType + ")";
        }
    }
}
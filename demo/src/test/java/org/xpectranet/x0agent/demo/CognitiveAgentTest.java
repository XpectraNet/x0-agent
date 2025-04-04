package org.xpectranet.x0agent.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CognitiveAgentTest {

    @Test
    public void testMintInsightAddsToMemory() {
        CognitiveAgent agent = new CognitiveAgent("TestAgent");
        agent.mintInsight("Test Memory", "L0", "X-Insight");

        assertEquals(1, agent.memory.size());
        assertEquals("Test Memory", agent.memory.get(0).content);
        assertEquals("L0", agent.memory.get(0).layer);
        assertEquals("X-Insight", agent.memory.get(0).originType);
    }

    @Test
    public void testReflectOnlyPrintsL2() {
        CognitiveAgent agent = new CognitiveAgent("Reflector");
        agent.mintInsight("L1 insight", "L1", "A-Insight");
        agent.mintInsight("L2 reflection", "L2", "A-Insight");

        assertDoesNotThrow(agent::reflect);
    }

    @Test
    public void testRemixCreatesL4InsightWithProvenance() {
        CognitiveAgent a = new CognitiveAgent("AgentA");
        CognitiveAgent b = new CognitiveAgent("AgentB");

        b.mintInsight("Divergent Thought", "L3", "A-Insight");

        a.remixWith(b);

        assertEquals(1, a.memory.size());

        CognitiveAgent.Insight remixed = a.memory.get(0);

        assertEquals("L4", remixed.layer);
        assertEquals("A-Insight", remixed.originType);
        assertTrue(remixed.content.contains("REMIX"));
        assertTrue(remixed.content.contains("Divergent Thought"));
        assertTrue(remixed.content.contains("AgentA"));
    }

    @Test
    public void testRemixHonorsRemixBoundarySymbolism() {
        CognitiveAgent b = new CognitiveAgent("AgentB");
        CognitiveAgent a = new CognitiveAgent("AgentA");

        b.mintInsight("Static Observation", "L1", "A-Insight");

        a.remixWith(b);

        assertEquals(0, a.memory.size());
    }
}
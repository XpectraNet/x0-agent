
package org.xpectranet.x0.demo;

import org.xpectranet.sdk.agent.AgentContext;
import org.xpectranet.sdk.memory.InsightEngine;
import org.xpectranet.sdk.model.Insight;

import java.util.List;

public class MemoryInsightLoop {
    public static void main(String[] args) {
        try {
            System.out.println("=== XpectraNet Memory Remix Loop ===");

            AgentContext agent = AgentContext.fromJson("data/agent-config.json");
            System.out.println("Loaded agent: " + agent.glyph);

            InsightEngine engine = new InsightEngine(agent);
            List<Insight> recent = engine.observeRecentInsights();
            System.out.println("Observed " + recent.size() + " insights...");

            for (Insight i : recent) {
                System.out.println("\nOriginal Insight:");
                System.out.println("  " + i.text + " [" + i.emotion + ", " + i.layer + "]");
                Insight remix = engine.remix(i);
                if (remix != null) {
                    System.out.println("→ Remixed by " + remix.author + ":");
                    System.out.println("  " + remix.text + " [" + remix.emotion + ", " + remix.layer + "]");
                    System.out.println("  RemixOf: " + remix.remixOf + ", XPDT: " + remix.xpdtStake);
                } else {
                    System.out.println("No symbolic remix rule triggered.");
                }
            }

            System.out.println("\nRemix loop completed.");
        } catch (Exception e) {
            System.err.println("Error in remix loop: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package org.xpectranet.x0agent.ritual;

public interface RitualService {
    String mint(String content);
    String remix(String sourceId);
    String validate(String insightId);
}
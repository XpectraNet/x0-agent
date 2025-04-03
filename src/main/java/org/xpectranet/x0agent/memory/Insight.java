package org.xpectranet.x0agent.memory;

public class Insight {
    private final String id;
    private final String content;

    public Insight(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
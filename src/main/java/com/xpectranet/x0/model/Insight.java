package com.xpectranet.x0.model;

import java.util.List;

public class Insight {
    private String layer;
    private String content;
    private List<String> tags;

    // Getters and Setters
    public String getLayer() { return layer; }
    public void setLayer(String layer) { this.layer = layer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}
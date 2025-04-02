package com.xpectranet.x0.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 * Insight model representing a unit of memory in the XpectraNet protocol.
 */
@Schema(description = "Represents an insight object with cognitive layer, content, and symbolic tags")
public class Insight {
    @Schema(description = "Cognitive layer (L0–L9)", example = "L2")
    private String layer;

    @Schema(description = "Raw or refined content of the insight", example = "Burnout is a signal, not a sentence")
    private String content;

    @Schema(description = "Symbolic tags for memory indexing", example = "["burnout", "resonance"]")
    private List<String> tags;

    public String getLayer() { return layer; }
    public void setLayer(String layer) { this.layer = layer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}
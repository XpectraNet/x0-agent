package com.xpectranet.x0.api;

import com.xpectranet.x0.service.GraphService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * REST controller to handle graph traversal requests.
 */
@RestController
@RequestMapping("/api/graph")
@Tag(name = "Graph API", description = "Endpoints for traversing the memory graph")
public class GraphController {

    private final GraphService graphService;

    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    /**
     * Traverses the insight graph using tag or layer filters.
     */
    @GetMapping("/traverse")
    @Operation(
        summary = "Traverse the insight graph",
        description = "Traverse insights by symbolic tag or cognitive layer"
    )
    public ResponseEntity<String> traverse(
            @Parameter(description = "Tag to filter insights (e.g., 'burnout')") 
            @RequestParam(required = false) String tag,

            @Parameter(description = "Cognitive layer to filter (e.g., 'L7')") 
            @RequestParam(required = false) String layer) {
        return ResponseEntity.ok(graphService.traverse(tag, layer));
    }
}
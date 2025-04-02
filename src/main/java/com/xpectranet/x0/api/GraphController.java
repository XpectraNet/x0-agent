package com.xpectranet.x0.api;

import com.xpectranet.x0.model.Insight;
import com.xpectranet.x0.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * REST controller to handle graph traversal requests.
 */
@RestController
@RequestMapping("/api/graph")
public class GraphController {

    private final GraphService graphService;

    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    /**
     * Traverses the insight graph using layer or tag-based parameters.
     */
    @GetMapping("/traverse")
    public ResponseEntity<String> traverse(@RequestParam(required = false) String tag,
                                           @RequestParam(required = false) String layer) {
        return ResponseEntity.ok(graphService.traverse(tag, layer));
    }
}
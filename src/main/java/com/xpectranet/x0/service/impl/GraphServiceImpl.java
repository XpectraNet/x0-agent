package com.xpectranet.x0.service.impl;

import com.xpectranet.x0.service.GraphService;
import org.springframework.stereotype.Service;

/**
 * Mock implementation of GraphService for demo purposes.
 */
@Service
public class GraphServiceImpl implements GraphService {
    @Override
    public String traverse(String tag, String layer) {
        return "Traversed insights by tag=" + tag + ", layer=" + layer;
    }
}
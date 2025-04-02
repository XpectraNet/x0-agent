package com.xpectranet.x0.service;

import com.xpectranet.x0.model.Insight;

/**
 * InsightService defines the interface for insight minting,
 * remixing, and validation.
 */
public interface InsightService {
    String mintInsight(Insight insight);
    String remixInsight(Insight insight);
    String validateInsight(Insight insight);
}
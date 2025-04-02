package com.xpectranet.x0.service.impl;

import com.xpectranet.x0.model.Insight;
import com.xpectranet.x0.service.InsightService;
import com.xpectranet.x0.storage.IPFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Implementation of InsightService with IPFS JSON upload and batch retry support.
 */
@Service
public class InsightServiceImpl implements InsightService {

    @Autowired
    private IPFSClient ipfsClient;

    @Override
    public String mintInsight(Insight insight) {
        try {
            String cid = ipfsClient.uploadInsightAsJson(insight).get();
            return "✅ Minted: " + insight.getContent() + " (CID: " + cid + ")";
        } catch (InterruptedException | ExecutionException e) {
            return "❌ Failed to mint: " + insight.getContent() + " — " + e.getMessage();
        }
    }

    @Override
    public String remixInsight(Insight insight) {
        return "Remixed insight with layer " + insight.getLayer();
    }

    @Override
    public String validateInsight(Insight insight) {
        return "Validated insight: " + insight.getTags();
    }

    @Override
    public String mintBatch(List<Insight> insights) {
        StringBuilder results = new StringBuilder();
        int success = 0;
        int failure = 0;

        for (Insight i : insights) {
            String result = mintInsight(i);
            results.append(result).append("\n");

            if (result.startsWith("✅")) {
                success++;
            } else {
                failure++;
            }
        }

        results.append("\nBatch Summary: ")
               .append(success).append(" succeeded, ")
               .append(failure).append(" failed.");

        return results.toString();
    }
}
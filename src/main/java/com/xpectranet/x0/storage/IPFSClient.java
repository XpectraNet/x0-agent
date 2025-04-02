package com.xpectranet.x0.storage;

import java.net.URI;
import java.net.http.*;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpectranet.x0.model.Insight;
import org.springframework.stereotype.Component;

/**
 * IPFS integration using Web3.Storage HTTP API to upload full Insight JSON.
 */
@Component
public class IPFSClient {

    private static final String API_TOKEN = "YOUR_API_TOKEN";
    private static final String API_URL = "https://api.web3.storage/upload";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CompletableFuture<String> uploadInsightAsJson(Insight insight) {
        try {
            String json = objectMapper.writeValueAsString(insight);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", "Bearer " + API_TOKEN)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

            HttpClient client = HttpClient.newHttpClient();

            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {
                        if (response.statusCode() == 200 || response.statusCode() == 202) {
                            return "Uploaded to IPFS successfully. CID: " + response.body();
                        } else {
                            return "ERROR: " + response.statusCode() + " - " + response.body();
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture("ERROR: " + e.getMessage());
        }
    }
}
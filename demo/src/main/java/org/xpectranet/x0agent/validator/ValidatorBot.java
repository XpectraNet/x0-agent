package org.xpectranet.x0agent.validator;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

/**
 * ValidatorBot loads the XKO ontology and provides symbolic property validation.
 * Powered by Apache Jena and aligned with the XPECTRANET protocol.
 */
public class ValidatorBot {

    private final Model xkoModel;

    /**
     * Load the XKO ontology from Turtle (.ttl) format.
     * @param ontologyPath the relative or absolute path to xko.ttl
     */
    public ValidatorBot(String ontologyPath) {
        this.xkoModel = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open(ontologyPath);

        if (in == null) {
            throw new IllegalArgumentException("Ontology file not found: " + ontologyPath);
        }

        xkoModel.read(in, null, "TTL");
        System.out.println("[XKO] Ontology loaded from " + ontologyPath);
    }

    /**
     * Check if a property URI exists in the ontology.
     * @param propertyURI full URI of the symbolic property
     * @return true if the property is present, false otherwise
     */
    public boolean hasProperty(String propertyURI) {
        Property prop = xkoModel.getProperty(propertyURI);
        return xkoModel.contains(null, prop);
    }

    /**
     * Entry point for symbolic validator bot test.
     */
    public static void main(String[] args) {
        // Example: load ontology and test property
        ValidatorBot bot = new ValidatorBot("src/main/resources/xko.ttl");

        String prefix = "https://xpectranet.org/xko#";
        String[] testProps = {
            "hasOriginType", "drivePreserve", "refines", "remixContract", "canonizes"
        };

        for (String p : testProps) {
            boolean exists = bot.hasProperty(prefix + p);
            System.out.println("✓ " + p + ": " + (exists ? "FOUND" : "not found"));
        }
    }
}
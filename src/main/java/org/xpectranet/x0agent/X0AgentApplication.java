package org.xpectranet.x0agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * X-0 Agent Application — entrypoint to symbolic memory net.
 * Part of the XPECTRANET Protocol for collaborative AI cognition.
 */
@SpringBootApplication
public class X0AgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(X0AgentApplication.class, args);
        System.out.println("🧠 X-0 Agent has entered the symbolic net.");
    }
}
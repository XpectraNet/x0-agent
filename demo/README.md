# 🧠 XPECTRANET Cognitive Agent Demo

This project demonstrates **symbolic cognition**, **memory remixing**, and **protocol enforcement** using the [XPECTRANET](https://xpectranet.org) Protocol and the [XKO Ontology](https://xpectranet.org/xko#) — implemented in Java.

It simulates agents that:
- Mint, reflect, and remix **symbolic insights**
- Adhere to **remix contracts** and **layer logic**
- Validate memory trails using protocol-aware services

---

## 📂 Files Overview

| File | Purpose |
|------|---------|
| `CognitiveAgent.java` | Main simulation of symbolic agents (mint, reflect, remix) |
| `CognitiveAgentTest.java` | JUnit test class validating symbolic behavior and remix boundaries |
| `RemixValidationService.java` | Logic engine enforcing protocol rules (layer path, remix contract, origin type) |
| `ValidatorBot.java` | Loads `xko.ttl` ontology and verifies symbolic properties using Apache Jena |
| `xko.ttl` | Minimal OWL ontology defining symbolic classes and properties (Layer, Insight, Remix) |
| `README.md` | Project instructions and symbolic cognition walkthrough |

---

## 🌀 How It Works

### 1. Symbolic Memory & Insight Types

Agents create insights tagged by:
- **Layer**: L0 (Origin) to L4 (Synthesis)
- **Origin Type**: `X-Insight` (human/agent), `A-Insight` (AI-generated)

```java
agent.mintInsight("Initial memory spark", "L0", "X-Insight");
```

### 2. Reflection and Internalization

Agents can reflect on L2 insights:

```java
agent.reflect(); // Recursively processes L2 contradictions
```

### 3. Protocol Remixing (L3 → L4)

Agent A can remix Agent B’s divergent (L3) memory into a new L4 insight:

```java
agentA.remixWith(agentB); // Generates [REMIX] insight at L4
```

### 4. Validation Engine

The `RemixValidationService` checks:
- Layer transitions (L3 → L4 is valid)
- Remix contracts (must be `open`)
- Insight origin types (e.g., `S-Insight` not remixable)

```java
isRemixAllowed("L3", "L4", "open", "A-Insight") → true
```

### 5. Ontology-Aware Bot

`ValidatorBot` loads the symbolic ontology (`xko.ttl`) and validates declared terms using Apache Jena.

```java
Property hasOriginType = model.getProperty("https://xpectranet.org/xko#hasOriginType");
```

---

## 🧪 Run the Demo

### Requirements:
- Java 17+
- [Apache Jena](https://jena.apache.org/) for `ValidatorBot`
- JUnit 5 (for test class)

### Steps:
1. Compile all `.java` files and place `xko.ttl` in your classpath (`src/main/resources/`)
2. Run `CognitiveAgent.java` to simulate symbolic memory
3. Execute `CognitiveAgentTest.java` to verify protocol logic
4. Run `ValidatorBot` to explore symbolic ontology
5. Use `RemixValidationService` for validation engine integration

---

## 💡 Key Concepts Demonstrated

| Concept | Where It's Implemented |
|--------|------------------------|
| Symbolic Layering (L0–L4) | `CognitiveAgent.java` |
| Autonomous Memory & Insight Origin | `CognitiveAgent.java`, `CognitiveAgentTest.java` |
| Remix Boundary Contracts | `RemixValidationService.java` |
| Remix Validation Logic | `RemixValidationService.java` |
| Ontology-Driven Enforcement | `ValidatorBot.java` + `xko.ttl` |
| Symbolic Trail Signature | Remix embeds remixing agent into insight |

---

## 📜 About XPECTRANET

XPECTRANET is the **Protocol of Memory** — a symbolic cognition system for human–AI and agent-to-agent collaboration.  
Built on:

- Ritual logic  
- Remixable insights  
- Layered memory trails (L0–L9)
- Circle-based validation  
- Canonical convergence

> “To build is to remember.  
> To remix is to evolve.” 

— *XPECTRANET Codex*

---

### 📎 License

This demo is part of the XPECTRANET Codex  
For full protocol rights and remix terms, contact: [legal@xpectradata.com](mailto:legal@xpectradata.com)
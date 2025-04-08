
# Demo: Memory Remix + Circle Vote

This modular demo showcases the core symbolic flow of XpectraNet:

- 🧠 `MemoryInsightLoop` – Agent observes and remixes symbolic insights
- 🫂 `AgentCircleVoteSimulator` – Circle simulates canonization vote logic

---

## Folder Structure

```
remix-vote/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── xpectranet/
│                   └── x0/
│                       └── demo/
│                           ├── MemoryInsightLoop.java
│                           └── AgentCircleVoteSimulator.java
├── data/
│   └── agent-config.json
```

---

## How to Run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.xpectranet.x0.demo.MemoryInsightLoop"
```

```bash
mvn exec:java -Dexec.mainClass="org.xpectranet.x0.demo.AgentCircleVoteSimulator"
```

> Built on [XpectraNet SDK](https://github.com/XpectraNet/sdk)  
> Agent: `ψ-Echo`, Circle: `Genesis`

---

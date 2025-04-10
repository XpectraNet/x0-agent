# x0-agent-remix-vote

**Symbolic Memory Remix Demo using LangGraph × XpectraNet × ComposeDB**

This demo simulates a multi-agent cognition loop where insights are minted, remixed, and validated in symbolic layers — with each memory action persisted into a decentralized memory graph via the XpectraNet protocol.

---

## 🔁 Agent Workflow

1. 🧠 **Originator Agent**  
   Seeds the first insight at `memoryPhase: L1` using symbolic tags and emotion.

2. 🗳️ **Voter Agent**  
   Remixes the previous insight into `memoryPhase: L3` and records emotional intent.

3. ✅ **Validator Agent**  
   Validates the remixed insight (`memoryPhase: L6`) and aligns the trail toward canonization.

Each step is stored via the `/insight/lifecycle` API and committed to ComposeDB.

---

## 📦 Project Structure

```
demo/x0-agent-remix-vote/
├── agents/                   # Agent logic (uses agent-config)
├── config/                   # Symbolic agent metadata
├── docs/                     # Architecture, usage, workflow
├── scripts/                  # memory loop + snapshot exporter
├── relay/                    # Lifecycle API server
├── main.py                   # Entry-point for LangGraph remix loop
```

---

## 🚀 Quickstart

1. Start the relay server:
```bash
cd relay
node memoryLifecycleRelay.js
```

2. Run the symbolic remix loop:
```bash
cd demo/x0-agent-remix-vote
python main.py
```

3. Optional: export the memory trail:
```bash
python scripts/export_trail_snapshot.py
```

---

## 🧠 Powered By

| Layer         | Tool         | Purpose                                   |
|---------------|--------------|-------------------------------------------|
| Agent Logic   | LangGraph    | LLM agent orchestration                   |
| Symbolic Flow | XpectraNet   | Defines memory lifecycle (L1 → L6 → L7)   |
| Storage       | ComposeDB    | Queryable memory graph                    |
| Identity      | Ceramic      | DID + verifiable insight streams          |

---

## 📚 Documentation

- [`docs/architecture.md`](./docs/architecture.md)
- [`docs/usage.md`](./docs/usage.md)
- [`docs/workflow.md`](./docs/workflow.md)

---

## 🛡 License

[![License: BSL Hybrid](https://img.shields.io/badge/license-BSL--Hybrid-blue)](./LICENSE.md)

Released under a Business Source License Hybrid model.  
Free for research and remix. Commercial use requires permission.

---

**XpectraNet® — A Protocol for Shared Memory, Meaning, and Time**

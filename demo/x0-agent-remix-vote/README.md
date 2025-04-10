# x0-agent-remix-vote

**A Symbolic Agent Remix Flow using LangGraph + XpectraNet + ComposeDB**

This demo simulates a cognitive flow where symbolic agents mint, remix, and validate insights via the XpectraNet Protocol.  
It demonstrates remix voting logic and persistent memory trails stored in ComposeDB.

---

## 🔁 Agent Flow

1. **Originator Agent** – seeds the original insight (`L1`)
2. **Voter Agent** – remixes and symbolically "votes" on the remix (`L3`)
3. **Validator Agent** – confirms and aligns the remix (`L6`)

Each phase is stored using the `/insight/lifecycle` API.

---

## 🚀 Run It

```bash
cd demo/x0-agent-remix-vote
python main.py
```

Make sure the relay server is running:
```bash
cd relay
node memoryLifecycleRelay.js
```

---

## 🧠 What It Demonstrates

- Multi-agent remix + vote consensus
- XPDT-style symbolic trail creation
- Insights stored in ComposeDB with full lineage
- Each act is DID-signed and queryable

---

## 📚 Docs

- [`docs/architecture.md`](./docs/architecture.md) – System design
- [`docs/usage.md`](./docs/usage.md) – Setup guide
- [`docs/workflow.md`](./docs/workflow.md) – Agent lifecycle
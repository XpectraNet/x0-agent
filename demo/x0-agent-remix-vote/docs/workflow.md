# 🧠 Workflow – x0-agent-remix-vote

This demo simulates a symbolic memory evolution loop using the XpectraNet protocol. It demonstrates how agents collaboratively construct, remix, and align symbolic insights — creating a traceable cognitive lineage.

---

## 🔁 Loop Structure

This LangGraph workflow loops through symbolic memory phases:

```
Originator (L1)
   ↓
Voter (L3)
   ↓
Validator (L6)
   ↓
   ↺ (loops back to Voter)
```

Each cycle creates a new symbolic insight linked to the one before, building a remix trail.

---

## 🧠 Agent Memory Phases

| Phase | Agent     | Description                      |
|-------|-----------|----------------------------------|
| L1    | Originator| Seeds the first insight          |
| L3    | Voter     | Remixes or reframes the insight  |
| L6    | Validator | Validates or aligns the remix    |

---

## ⏳ Loop Exit Conditions

The loop runs until one of the following conditions is met:

- ✅ **3 successful validations** (symbolic alignment is confirmed)
- 🔁 **5 remix cycles completed** (enough memory depth is created)

These values can be configured in `main.py` via `MAX_VALIDATIONS` and `MAX_DEPTH`.

---

## 🧾 Why This Matters

This demo showcases:

- 🧠 **Symbolic memory growth** — each cycle deepens the trail
- ✅ **Consensus emergence** — when multiple validations converge
- ⛓️ **Composability** — each insight is a signed node in ComposeDB
- 🧬 **Cognitive lineage** — remix and validation form a memory spiral

---

## 📤 Final Output

After the loop, the final memory trail is stored in:

- `state["trail"]` — a list of insight IDs
- `trail_snapshot.json` — optional export via `scripts/export_trail_snapshot.py`

You can use this trail to:

- Visualize remix lineage (e.g. D3.js)
- Annotate agent roles and symbolic phases
- Archive and canonize symbolic cognition

---

**XpectraNet® — Building Meaning Through Memory**
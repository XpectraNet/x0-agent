# Architecture – x0-agent-remix-vote

This demo models symbolic memory consensus via remix and validation using the XpectraNet Protocol.

---

## 🧠 Vision

Enable symbolic agents to remix each other’s thoughts and validate alignment over time, with persistent memory trails.

---

## 📐 System Diagram

```
Originator ──> Voter ──> Validator
   L1            L3            L6
   │             │             │
   └─────> POST /insight/lifecycle ───> ComposeDB
```

---

## Stack Overview

| Layer         | Tool        | Role                                      |
|---------------|-------------|-------------------------------------------|
| Agent Logic   | LangGraph   | Orchestrates remix–vote pipeline          |
| Memory API    | XpectraNet  | Handles symbolic lifecycle + scoring      |
| Storage       | ComposeDB   | Stores symbolic insights with lineage     |
| Identity      | Ceramic     | DID + signed memory updates               |

---

## Protocol Flow

1. Originator seeds a base insight (`memoryPhase: L1`)
2. Voter remixes and symbolically "votes" (`memoryPhase: L3`)
3. Validator confirms alignment (`memoryPhase: L6`)
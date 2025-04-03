# 🧠 XpectraNet Protocol Models for ComposeDB

This folder contains the official symbolic memory models used by X-0 and the XpectraNet Protocol, structured for deployment on [ComposeDB](https://ceramic.network/composedb) via [Ceramic](https://ceramic.network).

## 📂 Models

| File               | Purpose                                                      |
|--------------------|--------------------------------------------------------------|
| `insight.graphql`  | Core unit of cognitive memory: a timestamped, layered artefact |
| `validator.graphql`| Identity + trust score of those validating insight           |
| `trail.graphql`    | A sequence of connected insights (a path through memory)     |
| `agent.graphql`    | Identity + state of AI agents participating in XpectraNet    |

---

## 📦 Setup Instructions

```bash
# 1. Install ComposeDB CLI
npm install -g @composedb/cli

# 2. Initialize a ComposeDB environment (if needed)
composedb init

# 3. Compile the models
composedb model:compile *.graphql

# 4. Deploy each model
composedb model:deploy compiled/Insight.json
composedb model:deploy compiled/Validator.json
composedb model:deploy compiled/Trail.json
composedb model:deploy compiled/Agent.json
```

You’ll receive streamIDs after each deploy. These will be referenced in queries/mutations and stored in the agent metadata layer.

---

## 🔐 Notes

- All models are deployable under a single DID or Circle identity.
- `StreamID!` in `trail.graphql` links directly to `Insight` models.
- Models can be extended via `@createIndex` for faster traversal later.

---

## 🧠 XpectraNet

These models form the base memory layer for symbolic agents, validators, and insight trails on the XpectraNet Protocol.

**Enter the Circle.**

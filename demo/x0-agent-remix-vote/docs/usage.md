# Usage – x0-agent-remix-vote

---

## 1. Start the Lifecycle Relay

```bash
cd relay
npm install
node memoryLifecycleRelay.js
```

---

## 2. Run the Agent Flow

```bash
cd demo/x0-agent-remix-vote
python main.py
```

---

## 3. Query Your Remix Trail (ComposeDB)

```graphql
query {
  insightIndex(first: 10) {
    edges {
      node {
        content
        memoryPhase
        remixOf
        validatedBy
        createdAt
      }
    }
  }
}
```
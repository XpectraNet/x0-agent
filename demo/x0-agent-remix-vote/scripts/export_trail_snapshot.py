# export_trail_snapshot.py — Export full ComposeDB insight trail to JSON

import json
import requests

# ComposeDB GraphQL endpoint
GRAPHQL_ENDPOINT = "https://ceramic-clay.3boxlabs.com"  # or your local daemon

# Replace this with your real trail or load from memory_loop output
trail_ids = [
    "did:ceramic:trail1...",
    "did:ceramic:trail2...",
    "did:ceramic:trail3..."
]

def fetch_insight(insight_id):
    query = '''
    query GetInsight($id: ID!) {
      node(id: $id) {
        ... on Insight {
          id
          content
          memoryPhase
          emotion
          remixOf
          validatedBy
          tags
          createdAt
        }
      }
    }
    '''
    response = requests.post(
        f"{GRAPHQL_ENDPOINT}/graphql",
        json={"query": query, "variables": {"id": insight_id}},
        headers={"Content-Type": "application/json"}
    )
    return response.json().get("data", {}).get("node", {})

if __name__ == "__main__":
    print("🔍 Exporting trail snapshot...")

    full_trail = []
    for tid in trail_ids:
        node = fetch_insight(tid)
        if node:
            full_trail.append(node)

    with open("trail_snapshot.json", "w") as f:
        json.dump(full_trail, f, indent=2)

    print(f"✅ Exported {len(full_trail)} insights to trail_snapshot.json")
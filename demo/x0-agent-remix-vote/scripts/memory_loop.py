# memory_loop.py — Symbolic Remix Loop with Full ComposeDB Trail
# Persists a memory trail of all remixes and validations to ComposeDB

from langgraph.graph import StateGraph
from agents.originator import originator_agent
from agents.voter import voter_agent
from agents.validator import validator_agent

def build_loop_graph():
    builder = StateGraph()
    builder.add_node("origin", originator_agent)
    builder.add_node("vote", voter_agent)
    builder.add_node("validate", validator_agent)

    builder.set_entry_point("origin")
    builder.add_edge("origin", "vote")
    builder.add_edge("vote", "validate")
    builder.add_edge("validate", "vote")
    return builder.compile()

if __name__ == "__main__":
    graph = build_loop_graph()

    print("🌀 Starting symbolic remix loop (store full trail to ComposeDB)...\n")
    state = {
        "remix_depth": 0,
        "validated_count": 0,
        "emotion_history": [],
        "trail": []  # Will store sequence of insight IDs
    }

    MAX_DEPTH = 5
    MAX_VALIDATIONS = 3

    while state["remix_depth"] < MAX_DEPTH and state["validated_count"] < MAX_VALIDATIONS:
        print(f"🔁 Cycle {state['remix_depth'] + 1} | Validated: {state['validated_count']}")
        state = graph.invoke(state)

        # Track remix depth
        state["remix_depth"] += 1

        # Track validation count
        if state.get("last_action") == "validate":
            state["validated_count"] += 1

        # Store every insight ID into the memory trail
        trail_id = state.get("insight_id") or state.get("final_id")
        if trail_id:
            state["trail"].append(trail_id)

        print(f"➡️ Insight ID: {trail_id}")
        print("")

    print("✅ Remix loop complete. Trail stored.")
    print(f"Final Remix Depth: {state['remix_depth']} | Total Validations: {state['validated_count']}")
    print("🧠 ComposeDB Trail:")
    for idx, node_id in enumerate(state["trail"], start=1):
        print(f"  {idx}. {node_id}")

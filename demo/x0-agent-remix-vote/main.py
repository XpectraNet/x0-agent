# main.py — Symbolic Agent Remix Flow with LangGraph + Config
# This script runs an autonomous memory evolution loop using LangGraph.
# Each agent action (mint, remix, validate) is driven by external configuration.
# The symbolic memory trail is persisted in ComposeDB via the XpectraNet protocol.

import json
from langgraph.graph import StateGraph
from agents.originator import originator_agent
from agents.voter import voter_agent
from agents.validator import validator_agent

# 🔁 Load symbolic agent config
# Each agent's role, emotion profile, action type, and tags are defined externally
with open("config/agent-config.json") as f:
    AGENT_CONFIG = {a["role"]: a for a in json.load(f)["agents"]}

# 🧠 Define the LangGraph pipeline using StateGraph
# origin → vote → validate → vote → validate (loops until condition met)
def build_graph():
    builder = StateGraph()
    builder.add_node("origin", originator_agent)     # Agent 1: seeds L1 insight
    builder.add_node("vote", voter_agent)            # Agent 2: remixes into L3
    builder.add_node("validate", validator_agent)    # Agent 3: validates to L6

    builder.set_entry_point("origin")                # Entry point
    builder.add_edge("origin", "vote")
    builder.add_edge("vote", "validate")
    builder.add_edge("validate", "vote")             # Loop back for trail growth

    return builder.compile()

if __name__ == "__main__":
    print("🚀 Starting X0 Agent Remix Loop (config-based)...\n")

    # 🧾 Initialize graph + memory state
    graph = build_graph()

    state = {
        "remix_depth": 0,        # Number of remixes completed
        "validated_count": 0,    # Number of validations reached
        "trail": [],             # Track full insight ID lineage
        "agent_config": AGENT_CONFIG  # Inject symbolic roles into state
    }

    MAX_DEPTH = 5
    MAX_VALIDATIONS = 3

    # 🔁 Run loop until either remix depth or validation threshold is met
    while state["remix_depth"] < MAX_DEPTH and state["validated_count"] < MAX_VALIDATIONS:
        print(f"🔁 Cycle {state['remix_depth'] + 1} | Validated: {state['validated_count']}")
        
        # 🚦 Execute current step in LangGraph
        state = graph.invoke(state)

        # ⬆️ Increment counters and track trail
        if state.get("last_action") == "validate":
            state["validated_count"] += 1

        state["remix_depth"] += 1

        # 🧠 Store the current insight ID into trail
        trail_id = state.get("insight_id") or state.get("final_id")
        if trail_id:
            state["trail"].append(trail_id)

        print(f"➡️ Insight ID: {trail_id}")
        print("")

    # ✅ Final trail summary
    print("✅ Loop complete. Final insight trail:")
    for idx, tid in enumerate(state["trail"], start=1):
        print(f"  {idx}. {tid}")

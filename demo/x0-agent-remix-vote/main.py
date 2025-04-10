# main.py — X0 Remix + Vote Flow using LangGraph
# Agents co-author symbolic insights, vote on remixes, and validate alignment
# Memory is persisted via XpectraNet lifecycle API to ComposeDB

from langgraph.graph import StateGraph
from agents.originator import originator_agent
from agents.voter import voter_agent
from agents.validator import validator_agent

# Step-by-step:
# 1. Originator mints L1 insight
# 2. Voter votes + remixes insight into L3
# 3. Validator canonizes or aligns insight into L6 (or later L7)

# Build LangGraph pipeline
builder = StateGraph()

builder.add_node("origin", originator_agent)    # Seed an insight
builder.add_node("vote", voter_agent)           # Remix + vote
builder.add_node("validate", validator_agent)   # Align/canonize

# Define execution sequence
builder.set_entry_point("origin")
builder.add_edge("origin", "vote")
builder.add_edge("vote", "validate")
builder.set_exit_point("validate")

graph = builder.compile()

if __name__ == "__main__":
    print("🚀 Running X0 Remix+Vote memory cycle...\n")
    final_state = graph.invoke({})

    print("\n🧠 Symbolic trail complete.")
    print(f"Final Insight ID: {final_state.get('final_id')}")

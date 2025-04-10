from hooks.validate import validate_insight

def validator_agent(state):
    print("✅ Validator confirming remix alignment...")
    res = validate_insight(
        agent_id="did:agent:x0-validator",
        validated_id=state["insight_id"]
    )
    state["final_id"] = res.get("id")
    return state
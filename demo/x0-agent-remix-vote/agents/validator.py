from hooks.validate import validate_insight
import random

def validator_agent(state):
    config = state["agent_config"]["Validator"]
    emotion = random.choice(config["emotionProfile"])

    print(f"✅ {config['role']} is validating remix...")

    res = validate_insight(
        agent_id=config["agentId"],
        validated_id=state["insight_id"],
        emotion=emotion,
        layer=config["memoryPhase"],
        tags=config["tags"]
    )

    state["final_id"] = res.get("id")
    state["last_action"] = "validate"
    return state
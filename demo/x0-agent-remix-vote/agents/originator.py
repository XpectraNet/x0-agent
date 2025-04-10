from hooks.mint import mint_insight
import random

def originator_agent(state):
    config = state["agent_config"]["Originator"]
    emotion = random.choice(config["emotionProfile"])

    print(f"🧠 {config['role']} is seeding insight...")

    res = mint_insight(
        agent_id=config["agentId"],
        content="Reality may be a recursive remix of cognition.",
        emotion=emotion,
        tags=config["tags"],
        layer=config["memoryPhase"]
    )

    state["insight_id"] = res.get("id")
    state["content"] = res.get("insight", {}).get("content")
    state["last_action"] = "mint"
    return state
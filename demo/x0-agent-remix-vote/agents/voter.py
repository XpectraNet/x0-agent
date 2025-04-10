from hooks.remix import remix_insight
import random

def voter_agent(state):
    config = state["agent_config"]["Voter"]
    emotion = random.choice(config["emotionProfile"])

    print(f"🗳️ {config['role']} is remixing insight...")

    remix = f"Remixed idea: {state['content']} — perhaps cognition emerges through symbolic convergence."
    res = remix_insight(
        agent_id=config["agentId"],
        content=remix,
        emotion=emotion,
        tags=config["tags"],
        remix_of=state["insight_id"],
        layer=config["memoryPhase"]
    )

    state["insight_id"] = res.get("id")
    state["content"] = remix
    state["last_action"] = "remix"
    return state
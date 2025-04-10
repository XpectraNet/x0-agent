from hooks.remix import remix_insight
import random

def voter_agent(state):
    print("🗳️ Voter is remixing and symbolically endorsing the idea...")
    remix = f"Remixed perspective: {state['content']} — structure forms from divergence."
    emotion = random.choice(["Tension", "Creativity"])
    tags = ["remix", "vote"]

    res = remix_insight(
        agent_id="did:agent:x0-voter",
        content=remix,
        emotion=emotion,
        tags=tags,
        remix_of=state["insight_id"]
    )

    state["insight_id"] = res.get("id")
    state["content"] = remix
    return state
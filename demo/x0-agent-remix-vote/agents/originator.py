from hooks.mint import mint_insight
import random

def originator_agent(state):
    print("🧠 Originator is seeding an insight...")
    content = "Reality may be a recursive remix of cognition."
    emotion = random.choice(["Curiosity", "Inspiration"])
    tags = ["origin", "symbolic"]

    res = mint_insight(
        agent_id="did:agent:x0-originator",
        content=content,
        emotion=emotion,
        tags=tags
    )

    state["insight_id"] = res.get("id")
    state["content"] = content
    return state
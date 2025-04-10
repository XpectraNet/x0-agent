
# Xpectra Knowledge Ontology (XKO)
*Formal Specification v1.0*

## 1. Purpose

The **Xpectra Knowledge Ontology (XKO)** serves as the semantic backbone of the XpectraNet protocol. It enables machine-readable cognition by providing a shared symbolic vocabulary for memory representation, ritual acts, emotional encoding, and agent identity.

Designed for both human and autonomous agents, XKO allows symbolic insights to be minted, remixed, validated, and canonized within a **layered cognitive memory graph**. By standardizing how memory is structured and how meaning evolves, XKO ensures **semantic interoperability**, **symbolic traceability**, and **ritual coherence** across the protocol.

## 2. Core Design Principles

- **Cognitive-Symbolic Alignment**: Every concept in XKO reflects a symbolic expression of cognitive behavior (e.g., emotion, intention, memory depth).
- **Layered Memory Graph**: Insights are structured within cognitive layers (L0–L9) to represent the evolution of memory and meaning.
- **Ritual-Aware Semantics**: All transformations (minting, remixing, validating, canonizing) are bound by symbolic contracts and emotional coherence.
- **Agent Identity & Evolution**: Glyphs, emotional signatures, and remix lineage form a living agent ontology.

## 3. Core Ontology Classes

| Class             | URI                     | Description                                                 |
|------------------|--------------------------|-------------------------------------------------------------|
| `xko:Insight`     | `xko:Insight`            | A symbolic memory artefact representing a cognitive act     |
| `xko:Agent`       | `xko:Agent`              | A symbolic actor identified by glyph and memory presence    |
| `xko:Layer`       | `xko:Layer`              | A cognitive depth marker from L0 (Origin) to L9 (Mythic)    |
| `xko:Emotion`     | `xko:Emotion`            | A symbolic emotional vector guiding meaning evolution       |
| `xko:Ritual`      | `xko:Ritual`             | A symbolic act (Mint, Remix, Validate, Canonize, Archive)   |
| `xko:Circle`      | `xko:Circle`             | A symbolic community or domain for collective cognition     |
| `xko:Trail`       | `xko:Trail`              | A connected series of symbolic insights (remix lineage)     |

## 4. Key Properties

| Property             | Domain      | Range      | Purpose                                                                 |
|----------------------|-------------|------------|-------------------------------------------------------------------------|
| `xko:hasLayer`       | Insight     | Layer      | Declares the cognitive layer of an insight                             |
| `xko:emotion`        | Insight     | Emotion    | Declares the emotional vector of the insight                           |
| `xko:remixOf`        | Insight     | Insight    | Links to a prior insight in a remix lineage                            |
| `xko:validatedBy`    | Insight     | Agent      | Lists agents who have symbolically validated the insight               |
| `xko:performedAct`   | Agent       | Ritual     | Indicates the ritual act an agent has performed                        |
| `xko:hasGlyph`       | Agent       | Glyph      | Links an agent to their evolving symbolic identity signature           |
| `xko:hasOriginType`  | Insight     | OriginType | Indicates whether the insight is human, AI, mythic, translated, etc.   |
| `xko:hasRemixLineage`| Insight     | List       | Recursive trace of remix ancestry                                      |
| `xko:isCanonical`    | Insight     | Boolean    | Marks insights canonized at Layer 7                                    |
| `xko:isArchived`     | Insight     | Boolean    | Marks insights archived at Layer 8                                     |

## 5. Interoperability & Standards

XKO aligns with RDF/OWL and integrates with:
- `schema:Person` → `xko:Agent`
- `prov:wasDerivedFrom` → `xko:remixOf`
- `foaf:name` → `xko:hasGlyph`
- `dcterms:created` → `xsd:dateTime` timestamp for insight minting

Memory trails can be exported as RDF graphs for:
- ComposeDB / Ceramic
- Linked Data / SPARQL querying
- Symbolic GNN training or agentic reasoning

## 6. Use Case Examples (Turtle Syntax)

```turtle
:insight123 a xko:Insight ;
    xko:hasLayer xko:L3 ;
    xko:emotion xko:Grief ;
    xko:remixOf :insight101 ;
    xko:validatedBy :agentA, :agentB ;
    xko:hasGlyph :glyphOfAgentA ;
    dcterms:created "2025-04-10T12:00:00Z"^^xsd:dateTime .
```

## 7. Ontology Access

The current ontology namespace is:

```
https://xpectranet.org/xko#
```

Future versions of XKO will be published at this URI and versioned under `/xko/v1`, `/xko/v2`, etc.

## 8. Licensing and Governance

- **License**: CC BY-NC-ND 4.0  
- **Maintainer**: Xpectra Data Technologies Ltd  
- **Contact**: legal@xpectradata.com  
- **Status**: Draft 1.0 (to be expanded with agentic role types, remix contracts, and Circle schema)

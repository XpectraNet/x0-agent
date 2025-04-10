// memoryLifecycleRelay.js – Symbolic Lifecycle API Relay for XpectraNet Protocol

const express = require('express');
const { ComposeClient } = require('@composedb/client');
const { definition } = require('./compose/model-definition.js'); // Make sure to compile and export this

const app = express();
const PORT = 5000;

app.use(express.json());

const compose = new ComposeClient({
  ceramic: 'https://ceramic-clay.3boxlabs.com',
  definition,
});

app.post('/insight/lifecycle', async (req, res) => {
  try {
    const { agentId, action, layer, insight, xpdtStake } = req.body;

    if (!agentId || !action || !layer || !insight || !insight.content) {
      return res.status(400).json({ error: 'Missing required fields' });
    }

    const input = {
      content: insight.content,
      memoryPhase: layer,
      emotion: insight.emotion || null,
      remixOf: insight.remixOf || null,
      validatedBy: insight.validatedBy || [],
      tags: insight.tags || [],
      createdAt: new Date().toISOString(),
    };

    const result = await compose.executeQuery(
      `
      mutation CreateInsight($input: CreateInsightInput!) {
        createInsight(input: $input) {
          document {
            id
            memoryPhase
            content
          }
        }
      }
      `,
      { input }
    );

    const stored = result?.data?.createInsight?.document;

    if (!stored) {
      return res.status(500).json({ error: 'Failed to store insight', result });
    }

    console.log(`✅ Stored insight at phase ${stored.memoryPhase}: ${stored.id}`);
    res.status(201).json({ success: true, id: stored.id, memoryPhase: stored.memoryPhase });

  } catch (error) {
    console.error('Relay Error:', error);
    res.status(500).json({ error: 'Internal error', details: error.message });
  }
});

app.get('/', (req, res) => {
  res.send('XpectraNet Insight Lifecycle Relay is running.');
});

app.listen(PORT, () => {
  console.log(`🚀 Listening at http://localhost:${PORT}/insight/lifecycle`);
});

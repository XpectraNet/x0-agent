package org.xpectranet.x0.service;

public class CeramicClient {

    public static void publish(String json) {
        System.out.println("Simulated Ceramic publish: " + json);
    }

    public static String buildMutation(String content, String layer, String emotion, String ritual, String createdAt) {
        return """
mutation {
  createInsight(input: {
    content: \"""" + content + """\",
    layer: \"""" + layer + """\",
    emotion: \"""" + emotion + """\",
    ritual: \"""" + ritual + """\",
    createdAt: \"""" + createdAt + """\"
  }) {
    document {
      id
      content
      ritual
    }
  }
}
""";
    }
}

package api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonNodeExample {
    public static void main(String[] args) {
        String jsonResponse = "{ \"status\": \"success\", \"projects\": [ { \"projectName\": \"Project Alpha\", \"deadline\": \"2024-12-01\" }, { \"projectName\": \"Project Beta\", \"deadline\": \"2025-01-15\" } ] }";

        try {
            // Create ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON string into a JsonNode
            JsonNode rootNode = mapper.readTree(jsonResponse);

            // Navigate to the 'projects' array
            JsonNode projectsNode = rootNode.path("projects");

            // Check if projectsNode is an array
            if (projectsNode.isArray()) {
                System.out.println("Deadlines for projects:");
                for (JsonNode projectNode : projectsNode) {
                    String projectName = projectNode.path("projectName").asText();
                    String deadline = projectNode.path("deadline").asText();
                    System.out.println("Project: " + projectName + ", Deadline: " + deadline);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


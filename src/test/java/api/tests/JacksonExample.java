package api.tests;

import api.pojo.ApiResponse;
import api.pojo.Project;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        String jsonResponse = "{ \"status\": \"success\", \"projects\": [ { \"projectName\": \"Project Alpha\", \"deadline\": \"2024-12-01\" }, { \"projectName\": \"Project Beta\", \"deadline\": \"2025-01-15\" } ] }";

        try {
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Convert JSON string to ApiResponse object
            ApiResponse apiResponse = mapper.readValue(jsonResponse, ApiResponse.class);

            // Print deadlines of each project
            System.out.println("Deadlines for projects:");
            for (Project project : apiResponse.getProjects()) {
                System.out.println("Project: " + project.getProjectName() + ", Deadline: " + project.getDeadline());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


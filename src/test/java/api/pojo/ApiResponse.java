package api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// ApiResponse class representing the entire response
public class ApiResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("projects")
    private List<Project> projects;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
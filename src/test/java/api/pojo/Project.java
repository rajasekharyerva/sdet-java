package api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

// Project class representing each project object
public class Project {
    @JsonProperty("projectName")
    private String projectName;

    @JsonProperty("deadline")
    private String deadline;

    // Getters and Setters
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }
}




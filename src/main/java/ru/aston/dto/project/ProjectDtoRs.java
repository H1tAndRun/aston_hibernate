package ru.aston.dto.project;

public class ProjectDtoRs {

    private Integer id;

    private String projectName;

    private String projectClient;

    public ProjectDtoRs(Integer id, String projectName, String projectClient) {
        this.id = id;
        this.projectName = projectName;
        this.projectClient = projectClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectClient() {
        return projectClient;
    }

    public void setProjectClient(String projectClient) {
        this.projectClient = projectClient;
    }
}

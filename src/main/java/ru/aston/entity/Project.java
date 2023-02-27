package ru.aston.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name = "name_project")
    private String nameProject;
 
    @Column(name = "project_client")
    private String projectClient;
 
    @ManyToMany
    @JoinTable(
        name = "projects_workers",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "worker_id"))
    private List<Worker> workers;

    public Project() {
    }

    public Project(Integer id, String nameProject, String projectClient) {
        this.id = id;
        this.nameProject = nameProject;
        this.projectClient = projectClient;
    }

    public Project(String nameProject, String projectClient) {
        this.nameProject = nameProject;
        this.projectClient = projectClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getProjectClient() {
        return projectClient;
    }

    public void setProjectClient(String projectClient) {
        this.projectClient = projectClient;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", nameProject='" + nameProject + '\'' +
                ", projectClient='" + projectClient + '\'' +
                '}';
    }
}

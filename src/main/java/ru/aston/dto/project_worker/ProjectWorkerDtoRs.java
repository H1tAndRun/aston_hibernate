package ru.aston.dto.project_worker;

public class ProjectWorkerDtoRs {

    private Integer workerId;

    private Integer projectId;

    private String projectName;

    private String workerName;

    private String workerLastName;

    private String workerRole;

    public ProjectWorkerDtoRs(Integer projectId, Integer workerId, String projectName, String workerName,
                              String workerLastName, String workerRole) {
        this.projectId = projectId;
        this.workerId = workerId;
        this.projectName = projectName;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.workerRole = workerRole;
    }

    public Integer getProject_id() {
        return projectId;
    }

    public void setProject_id(Integer project_id) {
        this.projectId = project_id;
    }

    public Integer getWorker_id() {
        return workerId;
    }

    public void setWorker_id(Integer worker_id) {
        this.workerId = worker_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerLastName() {
        return workerLastName;
    }

    public void setWorkerLastName(String workerLastName) {
        this.workerLastName = workerLastName;
    }

    public String getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(String workerRole) {
        this.workerRole = workerRole;
    }

    @Override
    public String toString() {
        return "ProjectWorkersDtoRs{" +
                "worker_id=" + workerId +
                ", project_id=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", workerName='" + workerName + '\'' +
                ", workerLastName='" + workerLastName + '\'' +
                ", workerRole='" + workerRole + '\'' +
                '}';
    }
}

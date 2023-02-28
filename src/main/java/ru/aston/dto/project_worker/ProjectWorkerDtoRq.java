package ru.aston.dto.project_worker;

public class ProjectWorkerDtoRq {

    private Integer workerId;

    private Integer projectId;

    public ProjectWorkerDtoRq(Integer workerId, Integer projectId) {
        this.workerId = workerId;
        this.projectId = projectId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ProjectWorkerDtoRq{" +
                "workerId=" + workerId +
                ", projectId=" + projectId +
                '}';
    }
}

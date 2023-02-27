package ru.aston.service;

import ru.aston.dto.project.ProjectDtoRq;
import ru.aston.dto.project.ProjectDtoRs;
import ru.aston.dto.project_worker.ProjectWorkerDtoRq;
import ru.aston.dto.project_worker.ProjectWorkerDtoRs;
import java.util.List;

public interface ProjectService {

    List<ProjectDtoRs> getAllProject();

    void saveOrUpdateProject(ProjectDtoRq projectDtoRq);

    ProjectDtoRs getProjectById(Integer id);

    void deleteProject(Integer id);

    List<ProjectWorkerDtoRs> getProjectsWorkers();

    void deleteProjectWorker(Integer worker_id, Integer project_id);

    void saveProjectWorker(ProjectWorkerDtoRq projectWorkerDtoRq);
}

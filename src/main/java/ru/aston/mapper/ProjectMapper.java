package ru.aston.mapper;

import org.springframework.stereotype.Controller;
import ru.aston.dto.project.ProjectDtoRq;
import ru.aston.dto.project.ProjectDtoRs;
import ru.aston.dto.project_worker.ProjectWorkerDtoRs;
import ru.aston.entity.Project;
import ru.aston.entity.Worker;

@Controller
public class ProjectMapper {

    public ProjectDtoRs castFromEntity(Project project) {
        return new ProjectDtoRs(project.getId(),
                project.getNameProject(),
                project.getProjectClient());
    }

    public Project castFromDtoRq(ProjectDtoRq projectDtoRq) {
        return new Project(projectDtoRq.getId(),
                projectDtoRq.getProjectName(),
                projectDtoRq.getProjectClient());
    }

    public ProjectWorkerDtoRs castFromEntityToProjectWorkersDtoRs(Project project, Worker worker) {
        return new ProjectWorkerDtoRs(project.getId(),
                worker.getId(),
                project.getNameProject(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getRole().getRoleName());
    }
}

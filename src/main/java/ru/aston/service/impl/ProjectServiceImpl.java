package ru.aston.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.dao.ProjectDao;
import ru.aston.dto.project.ProjectDtoRq;
import ru.aston.dto.project.ProjectDtoRs;
import ru.aston.dto.project_worker.ProjectWorkerDtoRq;
import ru.aston.dto.project_worker.ProjectWorkerDtoRs;
import ru.aston.mapper.ProjectMapper;
import ru.aston.service.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao, ProjectMapper projectMapper) {
        this.projectDao = projectDao;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDtoRs> getAllProject() {
        return projectDao.getAllProject()
                .stream()
                .map(projectMapper::castFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateProject(ProjectDtoRq projectDtoRq) {
        projectDao.saveOrUpdateProject(projectMapper.castFromDtoRq(projectDtoRq));
    }

    public ProjectDtoRs getProjectById(Integer id) {
        return projectMapper.castFromEntity(projectDao.getProjectById(id));
    }

    @Override
    public void deleteProject(Integer id) {
        projectDao.deleteProjectById(id);
    }

    public List<ProjectWorkerDtoRs> getProjectsWorkers() {
        return projectDao.getProjectWorkers().stream()
                .flatMap(project -> project.getWorkers().stream()
                        .map(worker -> projectMapper
                                .castFromEntityToProjectWorkersDtoRs(project, worker)))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProjectWorker(Integer worker_id, Integer project_id) {
        projectDao.deleteProjectWorker(worker_id, project_id);
    }

    @Override
    public void saveProjectWorker(ProjectWorkerDtoRq projectWorkerDtoRq) {
        projectDao.saveProjectWorkers(projectWorkerDtoRq);
    }
}

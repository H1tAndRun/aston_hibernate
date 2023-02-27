package ru.aston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aston.dto.project.ProjectDtoRq;
import ru.aston.dto.project_worker.ProjectWorkerDtoRq;
import ru.aston.service.ProjectService;
import ru.aston.service.WorkerService;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    private final WorkerService workerService;

    @Autowired
    public ProjectController(ProjectService projectService, WorkerService workerService) {
        this.workerService = workerService;
        this.projectService = projectService;
    }

    @GetMapping
    public String getAllProject(Model model) {
        model.addAttribute("projects", projectService.getAllProject());
        return "get-all-project";
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDtoRq());
        return "create-project";
    }

    @PostMapping("/create")
    public String createProject(ProjectDtoRq projectDtoRq) {
        projectService.saveOrUpdateProject(projectDtoRq);
        return "redirect:/project";
    }

    @GetMapping("/update/{id}")
    public String updateProject(@PathVariable Integer id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "update-project";
    }

    @PostMapping("/update/{id}")
    public String updateProject(ProjectDtoRq projectDtoRq) {
        projectService.saveOrUpdateProject(projectDtoRq);
        return "redirect:/project";
    }

    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return "redirect:/project";
    }

    @GetMapping("/worker")
    public String GetProjectsWorker(Model model) {
        model.addAttribute("projects", projectService.getProjectsWorkers());
        return "get-projects-workers";
    }

    @GetMapping("/worker/create")
    public String createProjectWorker(Model model) {
        model.addAttribute("projects", projectService.getAllProject());
        model.addAttribute("workers", workerService.getAllWorker());
        return "create-project-worker";
    }

    @PostMapping("/worker/create")
    public String createProjectWorker(ProjectWorkerDtoRq projectWorkerDtoRq) {
        projectService.saveProjectWorker(projectWorkerDtoRq);
        return "redirect:/project/worker";
    }

    @PostMapping("/worker/delete")
    public String deleteProjectWorker(@RequestParam Integer projectId, @RequestParam Integer workerId) {
        projectService.deleteProjectWorker(workerId, projectId);
        return "redirect:/project/worker";
    }
}

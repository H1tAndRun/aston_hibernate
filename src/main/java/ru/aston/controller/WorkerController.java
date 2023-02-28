package ru.aston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aston.dto.worker.WorkerDtoRq;
import ru.aston.service.DepartmentsService;
import ru.aston.service.impl.RoleServiceImpl;
import ru.aston.service.impl.WorkerServiceImpl;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerServiceImpl workerServiceImpl;

    private final DepartmentsService departmentsService;

    private final RoleServiceImpl roleServiceImpl;


    @Autowired
    public WorkerController(WorkerServiceImpl workerServiceImpl,
                            DepartmentsService departmentsService,
                            RoleServiceImpl roleServiceImpl) {
        this.workerServiceImpl = workerServiceImpl;
        this.departmentsService = departmentsService;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping()
    public String getAllWorker(Model model) {
        model.addAttribute("workers", workerServiceImpl.getAllWorker());
        return "get-all-workers";
    }

    @GetMapping("/create")
    public String createWorker(Model model) {
        model.addAttribute("worker", new WorkerDtoRq());
        model.addAttribute("roles", roleServiceImpl.getAllRole());
        model.addAttribute("departments", departmentsService.getAllDepartment());
        return "create-workers";
    }

    @PostMapping("/create")
    public String createWorker(WorkerDtoRq workerDtoRq) {
        workerServiceImpl.saveOrUpdateWorker(workerDtoRq);
        return "redirect:/worker";
    }

    @GetMapping("/update/{id}")
    public String updateWorkerForm(@PathVariable int id, Model model) {
        model.addAttribute("worker", workerServiceImpl.getWorkerById(id));
        model.addAttribute("departments", departmentsService.getAllDepartment());
        model.addAttribute("roles", roleServiceImpl.getAllRole());
        return "update-worker";
    }

    @PostMapping("/update/{id}")
    public String updateWorker(WorkerDtoRq workerDtoRq) {
        workerServiceImpl.saveOrUpdateWorker(workerDtoRq);
        return "redirect:/worker";
    }

    @PostMapping("/delete/{id}")
    public String deleteWorker(@PathVariable int id) {
        workerServiceImpl.deleteWorker(id);
        return "redirect:/worker";
    }
}

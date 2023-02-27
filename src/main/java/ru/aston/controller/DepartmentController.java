package ru.aston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aston.dto.department.DepartmentDtoRq;
import ru.aston.service.DepartmentsService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentsService departmentService;

    @Autowired
    public DepartmentController(DepartmentsService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String getAllDepartment(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "get-all-departments";
    }

    @GetMapping("/create")
    public String createDepartment(Model model) {
        model.addAttribute(new DepartmentDtoRq());
        return "create-department";
    }

    @PostMapping("/create")
    public String createDepartment(DepartmentDtoRq departmentDtoRq) {
        departmentService.saveOrUpdateDepartment(departmentDtoRq);
        return "redirect:/department";
    }

    @GetMapping("/update/{id}")
    public String updateDepartment(@PathVariable Integer id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "update-department";
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(DepartmentDtoRq departmentDtoRq) {
        departmentService.saveOrUpdateDepartment(departmentDtoRq);
        return "redirect:/department";
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department";
    }
}

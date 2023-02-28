package ru.aston.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aston.dto.role.RoleDtoRq;
import ru.aston.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllRole(Model model) {
        model.addAttribute("roles", roleService.getAllRole());
        return "get-all-roles";
    }

    @GetMapping("/create")
    public String createRole(Model model) {
        model.addAttribute("role", new RoleDtoRq());
        return "create-role";
    }

    @PostMapping("/create")
    public String createRole(RoleDtoRq roleDtoRq) {
        roleService.saveOrUpdateRole(roleDtoRq);
        return "redirect:/role";
    }

    @GetMapping("/update/{id}")
    public String updateRole(@PathVariable Integer id, Model model) {
        model.addAttribute("role", roleService.getRoleById(id));
        return "update-role";
    }

    @PostMapping("/update/{id}")
    public String updateRole(RoleDtoRq roleDtoRq) {
        roleService.saveOrUpdateRole(roleDtoRq);
        return "redirect:/role";
    }


    @PostMapping("/delete/{id}")
    public String deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return "redirect:/role";
    }
}

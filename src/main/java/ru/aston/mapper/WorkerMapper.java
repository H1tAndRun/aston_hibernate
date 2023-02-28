package ru.aston.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.dao.DepartmentDao;
import ru.aston.dao.RoleDao;
import ru.aston.dto.worker.WorkerDtoRq;
import ru.aston.dto.worker.WorkerDtoRs;
import ru.aston.entity.Department;
import ru.aston.entity.Role;
import ru.aston.entity.Worker;

@Component
public class WorkerMapper {

    private final RoleDao roleDao;

    private final DepartmentDao departmentDao;

    @Autowired
    public WorkerMapper(RoleDao roleDao, DepartmentDao departmentDao) {
        this.roleDao = roleDao;
        this.departmentDao = departmentDao;
    }

    public Worker castFromDtoRq(WorkerDtoRq workerDtoRq) {
        Role role = roleDao.findRoleById(workerDtoRq.getRole_id());
        Department department = departmentDao.findDepartmentById(workerDtoRq.getDepartment_id());
        return new Worker.Builder()
                .setId(workerDtoRq.getId())
                .setFirstName(workerDtoRq.getFirstName())
                .setLastName(workerDtoRq.getLastName())
                .setEmail(workerDtoRq.getEmail())
                .setDepartment(department)
                .setRole(role)
                .build();
    }

    public WorkerDtoRs castFromEntity(Worker worker) {
        return new WorkerDtoRs(worker.getId(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getEmail(),
                worker.getDepartment().getDepartmentName(),
                worker.getRole().getRoleName());
    }
}

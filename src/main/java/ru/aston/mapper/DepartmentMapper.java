package ru.aston.mapper;

import org.springframework.stereotype.Component;
import ru.aston.dto.department.DepartmentDtoRq;
import ru.aston.dto.department.DepartmentDtoRs;
import ru.aston.entity.Department;

@Component
public class DepartmentMapper {

    public DepartmentDtoRs castFromEntity(Department department) {
        return new DepartmentDtoRs(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentLocation());
    }

    public Department castFromDtoRq(DepartmentDtoRq departmentDtoRq){
       return new Department(departmentDtoRq.getId(),
                departmentDtoRq.getDepartmentName(),
                departmentDtoRq.getDepartmentLocation());
    }
}

package ru.aston.service;

import ru.aston.dto.department.DepartmentDtoRq;
import ru.aston.dto.department.DepartmentDtoRs;
import java.util.List;

public interface DepartmentsService {

     void saveOrUpdateDepartment(DepartmentDtoRq departmentDtoRq);

     List<DepartmentDtoRs> getAllDepartment();

     DepartmentDtoRs getDepartmentById(Integer id);

     void deleteDepartment(Integer id);
}

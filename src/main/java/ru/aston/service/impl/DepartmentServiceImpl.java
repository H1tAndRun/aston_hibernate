package ru.aston.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.dao.DepartmentDao;
import ru.aston.dto.department.DepartmentDtoRq;
import ru.aston.dto.department.DepartmentDtoRs;
import ru.aston.mapper.DepartmentMapper;
import ru.aston.service.DepartmentsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentsService {

    private final DepartmentDao departmentDao;

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao, DepartmentMapper departmentMapper) {
        this.departmentDao = departmentDao;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public void saveOrUpdateDepartment(DepartmentDtoRq departmentDtoRq) {
        departmentDao.saveOrUpdateDepartment(departmentMapper.castFromDtoRq(departmentDtoRq));
    }

    @Override
    public List<DepartmentDtoRs> getAllDepartment() {
        return departmentDao.getAllDepartment()
                .stream()
                .map(departmentMapper::castFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDtoRs getDepartmentById(Integer id) {
        return departmentMapper.castFromEntity(departmentDao.findDepartmentById(id));
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentDao.deleteDepartmentById(id);
    }
}

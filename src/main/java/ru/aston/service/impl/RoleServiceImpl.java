package ru.aston.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.dao.RoleDao;
import ru.aston.dto.role.RoleDtoRq;
import ru.aston.dto.role.RoleDtoRs;
import ru.aston.mapper.RoleMapper;
import ru.aston.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDtoRs> getAllRole() {
        return roleDao.getAllRole()
                .stream()
                .map(roleMapper::castFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateRole(RoleDtoRq roleDtoRq) {
        roleDao.saveOrUpdateRole(roleMapper.castFromDtoRq(roleDtoRq));
    }

    @Override
    public RoleDtoRs getRoleById(Integer id) {
        return roleMapper.castFromEntity(roleDao.getRoleById(id));
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.deleteRoleById(id);
    }
}

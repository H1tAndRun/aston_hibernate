package ru.aston.service;

import ru.aston.dto.role.RoleDtoRq;
import ru.aston.dto.role.RoleDtoRs;
import java.util.List;

public interface RoleService {

    List<RoleDtoRs> getAllRole();

    void saveOrUpdateRole(RoleDtoRq roleDtoRq);

    RoleDtoRs getRoleById(Integer id);

    void deleteRole(Integer id);
}

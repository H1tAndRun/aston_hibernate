package ru.aston.mapper;

import org.springframework.stereotype.Controller;
import ru.aston.dto.role.RoleDtoRq;
import ru.aston.dto.role.RoleDtoRs;
import ru.aston.entity.Role;

@Controller
public class RoleMapper {


    public RoleDtoRs castFromEntity(Role role) {
        return new RoleDtoRs(role.getId(), role.getRoleName());
    }

    public Role castFromDtoRq(RoleDtoRq roleDtoRq) {
        return new Role(roleDtoRq.getId(), roleDtoRq.getRoleName());
    }
}

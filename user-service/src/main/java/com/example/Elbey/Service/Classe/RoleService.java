package com.example.Elbey.Service.Classe;

import com.example.Elbey.DAO.Entities.Role;
import com.example.Elbey.DAO.Repositories.RoleRepository;
import com.example.Elbey.Service.Interfaces.IRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService implements IRole {

    private RoleRepository roleRepository;
    @Override
    public Role add(Role a) {
        return roleRepository.save(a);
    }
}

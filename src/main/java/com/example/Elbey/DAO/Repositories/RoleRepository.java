package com.example.Elbey.DAO.Repositories;

import com.example.Elbey.DAO.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}

package com.example.Elbey.RestControllers;

import com.example.Elbey.DAO.Entities.Role;
import com.example.Elbey.Service.Interfaces.IRole;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleRestControllers {
    private IRole iRole;
    @PostMapping("/ajouterRole")

    public Role ajouter(@RequestBody Role role)
    {
        return iRole.add(role);
    }
}

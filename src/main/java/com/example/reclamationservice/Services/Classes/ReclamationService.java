package com.example.reclamationservice.Services.Classes;

import com.example.reclamationservice.Entities.Reclamation;
import com.example.reclamationservice.Repositories.ReclamationRepo;
import com.example.reclamationservice.Services.Interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReclamationService implements IReclamationService {

    @Autowired
    ReclamationRepo repo;
    @Override
    public Reclamation add(Reclamation a) {
        return repo.save(a);
    }

    @Override
    public Reclamation edit(Reclamation a) {
        return repo.save(a);
    }

    @Override
    public List<Reclamation> selectAll() {
        return repo.findAll();
    }

    @Override
    public Reclamation SelectById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);

    }
}

package com.example.reclamationservice.Services.Interfaces;

import com.example.reclamationservice.Entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation add(Reclamation a);
    Reclamation edit(Reclamation a);
    List<Reclamation> selectAll();
    Reclamation SelectById(int id);
    public void deleteById(int id);

}

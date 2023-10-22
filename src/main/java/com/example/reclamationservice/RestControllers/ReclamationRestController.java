package com.example.reclamationservice.RestControllers;


import com.example.reclamationservice.Entities.Reclamation;
import com.example.reclamationservice.Services.Interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReclamationRestController {
    private IReclamationService IRC;

    @PostMapping("/reclamation/add")
    public Reclamation add(@RequestBody Reclamation reclamation)
    {return IRC.add(reclamation);
    }

    @PutMapping("/reclamation/update")
    public Reclamation update(@RequestBody Reclamation reclamation)
    {return IRC.edit(reclamation);
    }
    @DeleteMapping("/reclamation/deleteReclamationbyID/{id}")
    public  Reclamation delete(@PathVariable int id)
    {   IRC.deleteById(id);
        return null;

    }

    @GetMapping("/reclamation/afficherReclamationbyID/{id}")
    public Reclamation AfficherByID(@PathVariable int id)
    {
        return IRC.SelectById(id);
    }

    @GetMapping ("/reclamation/afficherReclamation")
    public List<Reclamation> AfficherReclamations()
    {

        return IRC.selectAll();
    }

}

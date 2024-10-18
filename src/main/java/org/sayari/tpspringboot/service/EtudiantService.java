package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.EtudiantRepo;
import org.sayari.tpspringboot.model.Etudiant;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements CrudImpl<Etudiant> {
    @Autowired
    private EtudiantRepo etudiantRepo ;
    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public List<Etudiant> getAll() {
        return  etudiantRepo.findAll();
    }

    @Override
    public Etudiant get(Long id) {
        return etudiantRepo.findById(id).orElse(null);
    }

    @Override
    public Etudiant update(Etudiant value) {
        if(value == get(value.getIdEtudiant())){
            return etudiantRepo.save(value);
        }
        return null;
    }

    @Override
    public void remove(Long id) {
        etudiantRepo.deleteById(id);
    }
}

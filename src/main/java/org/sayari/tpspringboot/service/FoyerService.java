package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.FoyerRepo;
import org.sayari.tpspringboot.model.Foyer;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerService implements CrudImpl<Foyer> {
    @Autowired
    private FoyerRepo foyerRepo;
    @Override
    public Foyer add(Foyer value) {
        return foyerRepo.save(value);
    }

    @Override
    public List<Foyer> getAll() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer get(Long id) {
        return foyerRepo.findById(id).orElse(null);
    }

    @Override
    public Foyer update(Foyer value) {
        if(value==get(value.getIdFoyer())){
            return foyerRepo.save(value);
        }
        return null ;
    }

    @Override
    public void remove(Long id) {
        foyerRepo.deleteById(id);
    }
}

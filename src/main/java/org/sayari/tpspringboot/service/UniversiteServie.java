package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.UniversityRepo;
import org.sayari.tpspringboot.model.Universite;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServie implements CrudImpl<Universite> {
    @Autowired
    private UniversityRepo universiteRepo;


    @Override
    public Universite add(Universite value) {
        return universiteRepo.save(value);
    }

    @Override
    public List<Universite> getAll() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite get(Long id) {
        return universiteRepo.findById(id).orElse(null);
    }

    @Override
    public Universite update(Universite value) {
        if(get(value.getIdUniversite())==value){
            return universiteRepo.save(value);
        }
        return null ;
    }

    @Override
    public void remove(Long id) {
        universiteRepo.deleteById(id);
    }
}

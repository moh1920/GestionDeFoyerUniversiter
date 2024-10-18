package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.ChambreRepo;
import org.sayari.tpspringboot.model.Chambre;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService implements CrudImpl<Chambre> {


    @Autowired
    private ChambreRepo chambreRepo ;

    @Override
    public Chambre add(Chambre value) {
        chambreRepo.save(value);
        return value ;
    }

    @Override
    public List<Chambre> getAll() {
        return  chambreRepo.findAll();
    }

    @Override
    public Chambre get(Long id) {
        return chambreRepo.findById(id).orElse(null);
    }

    @Override
    public Chambre update(Chambre value) {
        if(chambreRepo.findById(value.getIdChambre())!=null) {
            chambreRepo.save(value);
        }else{
            throw new IllegalStateException("Cannot update");
        }
        return value;
    }

    @Override
    public void remove(Long id) {
       chambreRepo.deleteById(id);
    }

}

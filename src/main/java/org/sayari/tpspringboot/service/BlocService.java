package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.BlocRepo;
import org.sayari.tpspringboot.model.Bloc;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlocService implements CrudImpl<Bloc> {

    @Autowired
    private BlocRepo blocRepo ;

    @Override
    public Bloc add(Bloc value) {
        blocRepo.save(value) ;
        return value;
    }

    @Override
    public List<Bloc> getAll() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc get(Long id) {
        return blocRepo.findById(id).orElse(null);
    }

    @Override
    public Bloc update(Bloc value) {
        if(value==get(value.getIdBloc())){
            blocRepo.save(value);
        }
        return null;

    }

    @Override
    public void remove(Long id) {
        blocRepo.deleteById(id);
    }
}

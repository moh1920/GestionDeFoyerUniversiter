package org.sayari.tpspringboot.service;

import org.sayari.tpspringboot.Reposetry.ReservationRepo;
import org.sayari.tpspringboot.model.Reservation;
import org.sayari.tpspringboot.service.Impl.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements CrudImpl<Reservation> {

    @Autowired
    private ReservationRepo reservationRepo ;
    @Override
    public Reservation add(Reservation value) {
        return reservationRepo.save(value);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation get(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public Reservation update(Reservation value) {
     return reservationRepo.save(value);
    }

    @Override
    public void remove(Long id) {
        reservationRepo.deleteById(id);
    }


}

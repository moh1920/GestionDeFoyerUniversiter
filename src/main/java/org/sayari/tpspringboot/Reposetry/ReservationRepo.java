package org.sayari.tpspringboot.Reposetry;

import org.sayari.tpspringboot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}

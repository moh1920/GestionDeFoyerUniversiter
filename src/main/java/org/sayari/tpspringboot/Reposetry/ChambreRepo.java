package org.sayari.tpspringboot.Reposetry;

import org.sayari.tpspringboot.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {
}

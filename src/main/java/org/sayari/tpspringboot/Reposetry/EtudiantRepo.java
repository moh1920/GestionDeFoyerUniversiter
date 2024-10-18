package org.sayari.tpspringboot.Reposetry;

import org.sayari.tpspringboot.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
}

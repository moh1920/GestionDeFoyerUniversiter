package org.sayari.tpspringboot.Reposetry;

import org.sayari.tpspringboot.model.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<Universite,Long> {
}


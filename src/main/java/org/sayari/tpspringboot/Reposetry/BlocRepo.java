package org.sayari.tpspringboot.Reposetry;

import org.sayari.tpspringboot.model.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocRepo extends JpaRepository<Bloc,Long> {
}

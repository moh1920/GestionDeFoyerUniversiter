package org.sayari.tpspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;


    @ManyToMany
    private List<Etudiant> etudiantList ;
}

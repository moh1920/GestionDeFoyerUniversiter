package org.sayari.tpspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Etudiant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idEtudiant;
        private String nomEt;
        private String prenomEt;
        private Long cin;
        private String ecole;
        private Date dateNaissance;



        @ManyToMany(mappedBy = "etudiantList")
        private List<Reservation> reservationList ;




}

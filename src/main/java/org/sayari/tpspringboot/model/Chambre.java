package org.sayari.tpspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chambre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idChambre;
        private Long numeroChambre;
        @Enumerated(EnumType.STRING)
        private TypeChambre typeChambre ;


        @ManyToOne
        private Bloc bloc ;


        @OneToMany()
        private List<Reservation> reservationList ;


}

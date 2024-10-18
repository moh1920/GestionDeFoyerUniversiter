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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;


    @ManyToOne
    private Foyer foyer ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy ="bloc")
    private List<Chambre> chambres;


}

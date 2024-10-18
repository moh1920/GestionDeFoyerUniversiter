package org.sayari.tpspringboot.Controller;


import org.sayari.tpspringboot.model.Reservation;
import org.sayari.tpspringboot.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.add(reservation));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l ajout du reservation.");
        }
    }
    @GetMapping("/getAllReservation")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation>  reservationList = reservationService.getAll();
        if (reservationList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(reservationList);
    }
    @GetMapping("/getReservationById")
    public ResponseEntity<?> getReservationById(@RequestParam Long id) {
        Reservation reservation = reservationService.get(id);

        if ( reservation != null) {
            return ResponseEntity.status(HttpStatus.OK).body(reservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reservation non trouvé avec l ID: " + id);
        }
    }

    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            Reservation existRservation = reservationService.get(id);
            if (existRservation != null) {
                return ResponseEntity.ok(reservationService.update(reservation));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reservation non trouvé avec l ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du Reservation.");
        }
    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        Reservation reservation= reservationService.get(id);
        if(reservation != null){
            reservationService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reservation non trouvé avec l id: " + id);
        }
    }





}

package org.sayari.tpspringboot.Controller;

import org.sayari.tpspringboot.model.Chambre;
import org.sayari.tpspringboot.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class chambreController {
    @Autowired
    private ChambreService chambreService;


    @PostMapping("/addChambre")
    public ResponseEntity<?> addChambre(@RequestBody Chambre chambre) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( chambreService.add(chambre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du chambre.");
        }
    }
    @GetMapping("/getAllChambre")
    public ResponseEntity<List<Chambre>> getAllChambre() {
        List<Chambre> chambres = chambreService.getAll();
        if (chambres.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(chambres);
    }
    @GetMapping("/getChambreById")
    public ResponseEntity<?> getChambreById(@RequestParam Long id) {
        Chambre chambre = chambreService.get(id);

        if ( chambre != null) {
            return ResponseEntity.status(HttpStatus.OK).body(chambre);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("chambre non trouvé avec l'ID: " + id);
        }
    }

    @PutMapping("/updateChambre/{id}")
    public ResponseEntity<?> updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        try {
            Chambre existChambre = chambreService.get(id);
            if (existChambre != null) {
                return ResponseEntity.ok(chambreService.update(chambre));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chambre non trouvé avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du Chambre.");
        }
    }
    @DeleteMapping("/deleteChambre/{id}")
    public ResponseEntity<?> deleteChambre(@PathVariable Long id) {
        Chambre existChambre = chambreService.get(id);
        if(existChambre != null){
            chambreService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chambre non trouvé avec l'id: " + id);
        }
    }


}

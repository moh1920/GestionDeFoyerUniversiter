package org.sayari.tpspringboot.Controller;


import org.sayari.tpspringboot.model.Foyer;
import org.sayari.tpspringboot.service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {

     @Autowired
     private FoyerService foyerService ;

    @PostMapping("/addFoyer")
    public ResponseEntity<?> addFoyer(@RequestBody Foyer foyer ) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( foyerService.add(foyer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l ajout du foyer.");
        }
    }
    @GetMapping("/getAllFoyer")
    public ResponseEntity<List<Foyer>> getAllFoyer() {
        List<Foyer>  foyers = foyerService.getAll();
        if (foyers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(foyers);
    }
    @GetMapping("/getFoyerById")
    public ResponseEntity<?> getFoyerById(@RequestParam Long id) {
        Foyer foyer = foyerService.get(id);

        if ( foyer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(foyer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("foyer non trouvé avec l ID: " + id);
        }
    }

    @PutMapping("/updateFoyer/{id}")
    public ResponseEntity<?> updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        try {
            Foyer existFoyer = foyerService.get(id);
            if (existFoyer != null) {
                return ResponseEntity.ok(foyerService.update(foyer));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("foyer non trouvé avec l ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du foyer.");
        }
    }
    @DeleteMapping("/deleteFoyer/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable Long id) {
        Foyer foyer= foyerService.get(id);
        if(foyer != null){
            foyerService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("foyer non trouvé avec l id: " + id);
        }
    }




}

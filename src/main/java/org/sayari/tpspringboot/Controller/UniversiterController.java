package org.sayari.tpspringboot.Controller;


import org.sayari.tpspringboot.model.Universite;
import org.sayari.tpspringboot.service.UniversiteServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universiter")
public class UniversiterController {

    @Autowired
    private UniversiteServie universiterService;

    @PostMapping("/addUniversiter")
    public ResponseEntity<?> addUniversiter(@RequestBody Universite universite) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( universiterService.add(universite));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l ajout du universiter.");
        }
    }
    @GetMapping("/getAllUniversiter")
    public ResponseEntity<List<Universite>> getAllUniversiter() {
        List<Universite>  universites = universiterService.getAll();
        if (universites.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(universites);
    }
    @GetMapping("/getUniversiterById")
    public ResponseEntity<?> getUniversiterById(@RequestParam Long id) {
       Universite universite = universiterService.get(id);

        if ( universite != null) {
            return ResponseEntity.status(HttpStatus.OK).body(universite);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("universiter non trouvé avec l ID: " + id);
        }
    }

    @PutMapping("/updateUniversiter/{id}")
    public ResponseEntity<?> updateUniversiter(@PathVariable Long id, @RequestBody Universite universite) {
        try {
           Universite existUniversiter = universiterService.get(id);
            if (existUniversiter != null) {
                return ResponseEntity.ok(universiterService.update(universite ));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("universiter non trouvé avec l ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du Universiter.");
        }
    }
    @DeleteMapping("/deleteUniversitert/{id}")
    public ResponseEntity<?> deleteUniversiter(@PathVariable Long id) {
        Universite universite= universiterService.get(id);
        if(universite != null){
            universiterService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("universiter non trouvé avec l id: " + id);
        }
    }



}

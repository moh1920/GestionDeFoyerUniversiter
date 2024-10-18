package org.sayari.tpspringboot.Controller;

import org.sayari.tpspringboot.model.Chambre;
import org.sayari.tpspringboot.model.Etudiant;
import org.sayari.tpspringboot.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudinatController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/addEtudiant")
    public ResponseEntity<?> addEtudiant(@RequestBody Etudiant etudiant) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( etudiantService.add(etudiant));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l ajout du etudiant.");
        }
    }
    @GetMapping("/getAllEtudant")
    public ResponseEntity<List<Etudiant>> getAllEtudiant() {
        List<Etudiant>  etudiant = etudiantService.getAll();
        if (etudiant.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(etudiant);
    }
    @GetMapping("/getEtudiantById")
    public ResponseEntity<?> getEtudiantById(@RequestParam Long id) {
        Etudiant etudiant = etudiantService.get(id);

        if ( etudiant != null) {
            return ResponseEntity.status(HttpStatus.OK).body(etudiant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("etudiant non trouvé avec l ID: " + id);
        }
    }

    @PutMapping("/updateEtudiant/{id}")
    public ResponseEntity<?> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        try {
            Etudiant existetudiant = etudiantService.get(id);
            if (existetudiant != null) {
                return ResponseEntity.ok(etudiantService.update(etudiant));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("etudiant non trouvé avec l ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du Etudiant.");
        }
    }
    @DeleteMapping("/deleteEdutiant/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable Long id) {
        Etudiant etudiant= etudiantService.get(id);
        if(etudiant != null){
            etudiantService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("etudaint non trouvé avec l id: " + id);
        }
    }

}

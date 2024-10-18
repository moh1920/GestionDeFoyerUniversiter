package org.sayari.tpspringboot.Controller;

import org.sayari.tpspringboot.model.Bloc;
import org.sayari.tpspringboot.service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")    
public class BlocController {


    @Autowired
    private BlocService blocService;

    @PostMapping("/addBloc")
    public ResponseEntity<?> addBloc(@RequestBody Bloc bloc) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(blocService.add(bloc));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du bloc.");
        }
    }

    // Récupérer tous les blocs
    @GetMapping("/getAllBloc")
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.getAll();
        if (blocs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(blocs);
    }

    // Récupérer un bloc par son ID
    @GetMapping("/getBlocById")
    public ResponseEntity<?> getBlocById(@RequestParam Long id) {
        Bloc blocOpt = blocService.get(id);

        if (blocOpt != null) {
            return ResponseEntity.status(HttpStatus.OK).body(blocOpt);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bloc non trouvé avec l'ID: " + id);
        }
    }


    @PutMapping("/updateBloc/{id}")
    public ResponseEntity<?> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        try {
            Bloc existingBloc = blocService.get(id);
            if (existingBloc != null) {
                // Vous pouvez également mettre à jour l'ID du bloc ici si nécessaire
                return ResponseEntity.ok(blocService.update(bloc)); // Mettez à jour le bloc et renvoyez le résultat
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bloc non trouvé avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du bloc.");
        }
    }
    @DeleteMapping("/deleteBloc/{id}")
    public ResponseEntity<?> deleteBloc(@PathVariable Long id) {
        Bloc existBloc = blocService.get(id);
        if(existBloc != null){
            blocService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bloc non trouve avec l id: " + id);
        }
    }
}






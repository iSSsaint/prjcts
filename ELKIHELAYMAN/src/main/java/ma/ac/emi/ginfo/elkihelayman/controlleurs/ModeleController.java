package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.services.ModeleService;
import ma.ac.emi.ginfo.elkihelayman.services.MoteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modele")
public class ModeleController {
    private final ModeleService modeleService;
    private final MoteurService moteurService;

    public ModeleController(ModeleService modeleService, MoteurService moteurService) {
        this.modeleService = modeleService;
        this.moteurService = moteurService;
    }

    @GetMapping("/find/all")
    public List<Modele> modeles(){
        return modeleService.modeles();
    }

    @GetMapping("/find/{id}")
    public Optional<Modele> findModeleById(@PathVariable("id") Long id){
        return modeleService.findModeleById(id);
    }

    @PostMapping("/add")
    public Modele addModele(@RequestBody Modele modele){
        return modeleService.addModele(modele);
    }

    @PutMapping("/update/{id}")
    public Modele updateModele(@PathVariable("id") Long id, @RequestBody Modele modele){
        return modeleService.updateModele(modele);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModele(@PathVariable("id") Long id){
        Modele modele = modeleService.findModeleById(id)
                .orElse(null);
        modeleService.deleteModele(modele);
    }

    @PutMapping("/addM/{idModel}/{idMoteur}")
    public Modele addMoteurToModele(@PathVariable("idModel") Long idModel, @PathVariable("idMoteur") Integer idMoteur ){
        return modeleService.addMoteurToModele(modeleService.findModeleById(idModel).orElse(null),
                moteurService.findMoteurById(idMoteur).orElse(null));
    }


}

package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.entities.Moteur;
import ma.ac.emi.ginfo.elkihelayman.entities.Moteur;
import ma.ac.emi.ginfo.elkihelayman.services.DefautService;
import ma.ac.emi.ginfo.elkihelayman.services.MoteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moteur")
public class MoteurController {
    private final MoteurService moteurService;
    private final DefautService defautService;

    public MoteurController(MoteurService moteurService, DefautService defautService) {
        this.moteurService = moteurService;
        this.defautService = defautService;
    }

    @GetMapping("/find/all")
    public List<Moteur> moteurs(){
        return moteurService.moteurs();
    }

    @GetMapping("/find/{id}")
    public Optional<Moteur> findMoteurById(@PathVariable("id") Integer id){
        return moteurService.findMoteurById(id);
    }

    @PostMapping("/add")
    public Moteur addMoteur(@RequestBody Moteur moteur){
        return moteurService.addMoteur(moteur);
    }

    @PutMapping("/update")
    public Moteur updateMoteur(@RequestBody Moteur moteur){
        return moteurService.updateMoteur(moteur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMoteur(@PathVariable("id") Integer id){
        Moteur moteur = moteurService.findMoteurById(id)
                .orElse(null);
        moteurService.deleteMoteur(moteur);
    }

    @PutMapping("/addD/{idMoteur}/{idDefaut}")
    public Moteur addDefautToMoteur(@PathVariable("idMoteur") Integer idMoteur, @PathVariable("idDefaut") Long idDefaut ){
        return moteurService.addDefautToMoteur(moteurService.findMoteurById(idMoteur).orElse(null),
                defautService.findDefautById(idDefaut).orElse(null));
    }

    @PutMapping("/setK/{id}")
    public Moteur setKilometrage(@PathVariable("id") Integer id, @RequestBody Moteur moteurK){
        Moteur moteur = moteurService.findMoteurById(id).orElse(null);
        if (moteur != null) moteur.setKilometrage(moteurK.getKilometrage());
        return moteurService.updateMoteur(moteur);
    }


}

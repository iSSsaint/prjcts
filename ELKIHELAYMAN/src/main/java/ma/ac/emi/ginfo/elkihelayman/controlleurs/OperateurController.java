package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Operateur;
import ma.ac.emi.ginfo.elkihelayman.entities.Operateur;
import ma.ac.emi.ginfo.elkihelayman.services.DefautService;
import ma.ac.emi.ginfo.elkihelayman.services.OperateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operateur")
public class OperateurController {
    private final OperateurService operateurService;
    private final DefautService defautService;

    public OperateurController(OperateurService operateurService, DefautService defautService) {
        this.operateurService = operateurService;
        this.defautService = defautService;
    }

    @GetMapping("/find/all")
    public List<Operateur> operateurs(){
        return operateurService.operateurs();
    }

    @GetMapping("/find/{id}")
    public Optional<Operateur> findOperateurById(@PathVariable("id") Long id){
        return operateurService.findOperateurById(id);
    }

    @PostMapping("/add")
    public Operateur addOperateur(@RequestBody Operateur operateur){
        return operateurService.addOperateur(operateur);
    }

    @PutMapping("/update/{id}")
    public Operateur updateOperateur(@PathVariable("id") Long id, @RequestBody Operateur operateur){
        return operateurService.updateOperateur(operateur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperateur(@PathVariable("id") Long id){
        Operateur operateur = operateurService.findOperateurById(id)
                .orElse(null);
        operateurService.deleteOperateur(operateur);
    }

    @PutMapping("/addD/{idOperateur}/{idDefaut}")
    public Operateur addDefautToOperateur(@PathVariable("idOperateur") Long idOperateur, @PathVariable("idDefaut") Long idDefaut ){
        return operateurService.addDefautToOperateur(operateurService.findOperateurById(idOperateur).orElse(null),
                defautService.findDefautById(idDefaut).orElse(null));
    }


}

package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Employe;
import ma.ac.emi.ginfo.elkihelayman.entities.Usine;
import ma.ac.emi.ginfo.elkihelayman.repositories.EmployeRepository;
import ma.ac.emi.ginfo.elkihelayman.services.EmployeService;
import ma.ac.emi.ginfo.elkihelayman.services.ModeleService;
import ma.ac.emi.ginfo.elkihelayman.services.UsineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usine")
public class UsineController {
    private final UsineService usineService;
    private final EmployeService employeService;
    private final ModeleService modeleService;

    public UsineController(UsineService usineService,
                           EmployeService employeService,
                           ModeleService modeleService) {
        this.usineService = usineService;
        this.employeService = employeService;
        this.modeleService= modeleService;
    }

    @GetMapping("/find/all")
    public List<Usine> usines(){
        return usineService.usines();
    }

    @GetMapping("/find/{id}")
    public Optional<Usine> findUsineById(@PathVariable("id") Long id){
        return usineService.findUsineById(id);
    }

    @PostMapping("/add")
    public Usine addUsine(@RequestBody Usine usine){
        return usineService.addUsine(usine);
    }

    @PutMapping("/update/{id}")
    public Usine updateUsine(@PathVariable("id") Long id, @RequestBody Usine usine){
        return usineService.updateUsine(usine);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsine(@PathVariable("id") Long id){
        Usine usine = usineService.findUsineById(id)
                .orElse(null);
        usineService.deleteUsine(usine);
    }


    // Ajouter un employee dans un usine
    @PutMapping("/addE/{idU}/{idE}")
    public Usine addEmployeToUsine(@PathVariable("idU") Long idU,@PathVariable("idE") Long idE ){
        return usineService.addEmployeToUsine(usineService.findUsineById(idU).orElse(null),
                employeService.findEmployeById(idE).orElse(null));
    }

    @PutMapping("/addM/{idU}/{idM}")
    public Usine addModeleToUsine(@PathVariable("idU") Long idU,@PathVariable("idM") Long idM ){
        return usineService.addModeleToUsine(usineService.findUsineById(idU).orElse(null),
                modeleService.findModeleById(idM).orElse(null));
    }


    }

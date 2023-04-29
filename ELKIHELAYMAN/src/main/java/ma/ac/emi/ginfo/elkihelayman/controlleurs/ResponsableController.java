package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Responsable;
import ma.ac.emi.ginfo.elkihelayman.services.ResponsableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsable")
public class ResponsableController {
    private final ResponsableService responsableService;

    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    @GetMapping("/find/all")
    public List<Responsable> responsables(){
        return responsableService.responsables();
    }

    @GetMapping("/find/{id}")
    public Optional<Responsable> findResponsableById(@PathVariable("id") Long id){
        return responsableService.findResponsableById(id);
    }

    @PostMapping("/add")
    public Responsable addResponsable(@RequestBody Responsable responsable){
        return responsableService.addResponsable(responsable);
    }

    @PutMapping("/update/{id}")
    public Responsable updateResponsable(@PathVariable("id") Long id, @RequestBody Responsable responsable){
        return responsableService.updateResponsable(responsable);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteResponsable(@PathVariable("id") Long id){
        Responsable responsable = responsableService.findResponsableById(id)
                .orElse(null);
        responsableService.deleteResponsable(responsable);
    }


}

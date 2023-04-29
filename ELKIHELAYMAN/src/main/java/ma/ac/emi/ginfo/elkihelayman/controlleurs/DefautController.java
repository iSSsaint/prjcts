package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.services.DefautService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/defaut")
public class DefautController {
    private final DefautService defautService;

    public DefautController(DefautService defautService) {
        this.defautService = defautService;
    }

    @GetMapping("/find/all")
    public List<Defaut> defauts(){
        return defautService.defauts();
    }

    @GetMapping("/find/{id}")
    public Optional<Defaut> findDefautById(@PathVariable("id") Long id){
        return defautService.findDefautById(id);
    }

    @PostMapping("/add")
    public Defaut addDefaut(@RequestBody Defaut defaut){
        return defautService.addDefaut(defaut);
    }

    @PutMapping("/update/{id}")
    public Defaut updateDefaut(@PathVariable("id") Long id, @RequestBody Defaut defaut){
        return defautService.updateDefaut(defaut);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDefaut(@PathVariable("id") Long id){
        Defaut defaut = defautService.findDefautById(id)
                .orElse(null);
        defautService.deleteDefaut(defaut);
    }




}

package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Type;
import ma.ac.emi.ginfo.elkihelayman.entities.Type;
import ma.ac.emi.ginfo.elkihelayman.services.DefautService;
import ma.ac.emi.ginfo.elkihelayman.services.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type")
public class TypeController {
    private final TypeService typeService;
    private final DefautService defautService;

    public TypeController(TypeService typeService,
                          DefautService defautService) {
        this.typeService = typeService;
        this.defautService = defautService;
    }

    @GetMapping("/find/all")
    public List<Type> types(){
        return typeService.types();
    }

    @GetMapping("/find/{id}")
    public Optional<Type> findTypeById(@PathVariable("id") Integer id){
        return typeService.findTypeById(id);
    }

    @PostMapping("/add")
    public Type addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    @PutMapping("/update/{id}")
    public Type updateType(@PathVariable("id") Long id, @RequestBody Type type){
        return typeService.updateType(type);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteType(@PathVariable("id") Integer id){
        Type type = typeService.findTypeById(id)
                .orElse(null);
        typeService.deleteType(type);
    }

    @PutMapping("/addD/{idType}/{idDefaut}")
    public Type addDefautToType(@PathVariable("idType") Integer idType, @PathVariable("idDefaut") Long idDefaut ){
        return typeService.addDefautToType(typeService.findTypeById(idType).orElse(null),
                defautService.findDefautById(idDefaut).orElse(null));
    }


}

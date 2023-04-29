package ma.ac.emi.ginfo.elkihelayman.controlleurs;

import ma.ac.emi.ginfo.elkihelayman.entities.Employe;
import ma.ac.emi.ginfo.elkihelayman.services.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employe")
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/find/all")
    public List<Employe> employes(){
        return employeService.employes();
    }

    @GetMapping("/find/{id}")
    public Optional<Employe> findEmployeById(@PathVariable("id") Long id){
        return employeService.findEmployeById(id);
    }

    @PostMapping("/add")
    public Employe addEmploye(@RequestBody Employe employe){
        return employeService.addEmploye(employe);
    }

    @PutMapping("/update/{id}")
    public Employe updateEmploye(@PathVariable("id") Long id, @RequestBody Employe employe){
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable("id") Long id){
        Employe employe = employeService.findEmployeById(id)
                .orElse(null);
        employeService.deleteEmploye(employe);
    }
    

}

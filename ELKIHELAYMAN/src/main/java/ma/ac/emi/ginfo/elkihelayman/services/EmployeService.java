package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Employe;
import ma.ac.emi.ginfo.elkihelayman.repositories.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }


    public List<Employe> employes(){
        return employeRepository.findAll();
    }

    public Optional<Employe> findEmployeById(Long id){
        return employeRepository.findById(id);
    }

    public Employe addEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public Employe updateEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public void deleteEmploye(Employe employe){
        employeRepository.delete(employe);
    }

}

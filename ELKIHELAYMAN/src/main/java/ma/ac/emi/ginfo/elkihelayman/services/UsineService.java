package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Employe;
import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.entities.Usine;
import ma.ac.emi.ginfo.elkihelayman.repositories.UsineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsineService {
    private final UsineRepository usineRepository;

    public UsineService(UsineRepository usineRepository) {
        this.usineRepository = usineRepository;
    }


    public List<Usine> usines(){
        return usineRepository.findAll();
    }

    public Optional<Usine> findUsineById(Long id){
        return usineRepository.findById(id);
    }

    public Usine addUsine(Usine usine){
        return usineRepository.save(usine);
    }

    public Usine updateUsine(Usine usine){
        return usineRepository.save(usine);
    }

    public void deleteUsine(Usine usine){
        usineRepository.delete(usine);
    }

    public Usine addEmployeToUsine(Usine usine, Employe employe){
        usine.getEmployes().add(employe);
        employe.setUsine(usine);
        return usineRepository.save(usine);
    }

    public Usine addModeleToUsine(Usine usine, Modele modele){
        usine.getModeles().add(modele);
        modele.setUsine(usine);
        return usineRepository.save(usine);
    }

}

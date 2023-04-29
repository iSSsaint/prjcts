package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.entities.Operateur;
import ma.ac.emi.ginfo.elkihelayman.entities.Operateur;
import ma.ac.emi.ginfo.elkihelayman.repositories.OperateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperateurService {
    private final OperateurRepository operateurRepository;

    public OperateurService(OperateurRepository operateurRepository) {
        this.operateurRepository = operateurRepository;
    }


    public List<Operateur> operateurs(){
        return operateurRepository.findAll();
    }

    public Optional<Operateur> findOperateurById(Long id){
        return operateurRepository.findById(id);
    }

    public Operateur addOperateur(Operateur operateur){
        return operateurRepository.save(operateur);
    }

    public Operateur updateOperateur(Operateur operateur){
        return operateurRepository.save(operateur);
    }

    public void deleteOperateur(Operateur operateur){
        operateurRepository.delete(operateur);
    }

    public Operateur addDefautToOperateur(Operateur operateur, Defaut defaut){
        operateur.getDefauts().add(defaut);
        defaut.setOperateur(operateur);
        return operateurRepository.save(operateur);
    }
}

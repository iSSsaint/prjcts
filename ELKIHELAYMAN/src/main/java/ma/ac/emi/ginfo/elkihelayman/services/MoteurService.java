package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.entities.Moteur;
import ma.ac.emi.ginfo.elkihelayman.entities.Moteur;
import ma.ac.emi.ginfo.elkihelayman.repositories.MoteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoteurService {
    private final MoteurRepository moteurRepository;

    public MoteurService(MoteurRepository moteurRepository) {
        this.moteurRepository = moteurRepository;
    }


    public List<Moteur> moteurs(){
        return moteurRepository.findAll();
    }

    public Optional<Moteur> findMoteurById(Integer id){
        return moteurRepository.findById(id);
    }

    public Moteur addMoteur(Moteur moteur){
        return moteurRepository.save(moteur);
    }

    public Moteur updateMoteur(Moteur moteur){
        return moteurRepository.save(moteur);
    }

    public void deleteMoteur(Moteur moteur){
        moteurRepository.delete(moteur);
    }

    public Moteur addDefautToMoteur(Moteur moteur, Defaut defaut){
        moteur.getDefauts().add(defaut);
        defaut.setMoteur(moteur);
        return moteurRepository.save(moteur);
    }

    public Moteur setKilometrage(Moteur moteur , Integer km){
        moteur.setKilometrage(km);
        return moteurRepository.save(moteur);
    }

}

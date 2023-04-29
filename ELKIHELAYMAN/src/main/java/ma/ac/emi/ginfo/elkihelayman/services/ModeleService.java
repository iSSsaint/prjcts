package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.entities.Moteur;
import ma.ac.emi.ginfo.elkihelayman.repositories.ModeleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeleService {
    private final ModeleRepository modeleRepository;

    public ModeleService(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }


    public List<Modele> modeles(){
        return modeleRepository.findAll();
    }

    public Optional<Modele> findModeleById(Long id){
        return modeleRepository.findById(id);
    }

    public Modele addModele(Modele modele){
        return modeleRepository.save(modele);
    }

    public Modele updateModele(Modele modele){
        return modeleRepository.save(modele);
    }

    public void deleteModele(Modele modele){
        modeleRepository.delete(modele);
    }

    public Modele addMoteurToModele(Modele modele, Moteur moteur){
        modele.getMoteurs().add(moteur);
        moteur.setModele(modele);
        return modeleRepository.save(modele);
    }

}

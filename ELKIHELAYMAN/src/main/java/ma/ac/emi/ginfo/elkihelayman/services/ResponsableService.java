package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Modele;
import ma.ac.emi.ginfo.elkihelayman.entities.Responsable;
import ma.ac.emi.ginfo.elkihelayman.entities.Responsable;
import ma.ac.emi.ginfo.elkihelayman.repositories.ResponsableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableService {
    private final ResponsableRepository responsableRepository;

    public ResponsableService(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository;
    }


    public List<Responsable> responsables(){
        return responsableRepository.findAll();
    }

    public Optional<Responsable> findResponsableById(Long id){
        return responsableRepository.findById(id);
    }

    public Responsable addResponsable(Responsable responsable){
        return responsableRepository.save(responsable);
    }

    public Responsable updateResponsable(Responsable responsable){
        return responsableRepository.save(responsable);
    }

    public void deleteResponsable(Responsable responsable){
        responsableRepository.delete(responsable);
    }

    public Responsable addModeleToResponsable(Responsable responsable, Modele modele){
        responsable.getModeles().add(modele);
        modele.setResponsable(responsable);
        return responsableRepository.save(responsable);
    }
}

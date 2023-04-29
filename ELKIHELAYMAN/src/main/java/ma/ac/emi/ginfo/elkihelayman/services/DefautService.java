package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.repositories.DefautRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefautService {
    private final DefautRepository defautRepository;

    public DefautService(DefautRepository defautRepository) {
        this.defautRepository = defautRepository;
    }


    public List<Defaut> defauts(){
        return defautRepository.findAll();
    }

    public Optional<Defaut> findDefautById(Long id){
        return defautRepository.findById(id);
    }

    public Defaut addDefaut(Defaut defaut){
        return defautRepository.save(defaut);
    }

    public Defaut updateDefaut(Defaut defaut){
        return defautRepository.save(defaut);
    }

    public void deleteDefaut(Defaut defaut){
        defautRepository.delete(defaut);
    }

}

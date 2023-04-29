package ma.ac.emi.ginfo.elkihelayman.services;

import ma.ac.emi.ginfo.elkihelayman.entities.Defaut;
import ma.ac.emi.ginfo.elkihelayman.entities.Type;
import ma.ac.emi.ginfo.elkihelayman.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    public List<Type> types(){
        return typeRepository.findAll();
    }

    public Optional<Type> findTypeById(Integer id){
        return typeRepository.findById(id);
    }

    public Type addType(Type type){
        return typeRepository.save(type);
    }

    public Type updateType(Type type){
        return typeRepository.save(type);
    }

    public void deleteType(Type type){
        typeRepository.delete(type);
    }

    public Type addDefautToType(Type type, Defaut defaut){
        type.getDefauts().add(defaut);
        defaut.setType(type);
        return typeRepository.save(type);
    }

}

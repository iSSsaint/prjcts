package ma.ac.emi.ginfo.elkihelayman.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Operateur extends Employe{

    @JsonIgnore
    @OneToMany(mappedBy = "operateur", cascade = CascadeType.ALL)
    private List<Defaut> defauts = new ArrayList<>();

    public Operateur(String nom, String prenom, String fonction) {
        super(nom, prenom, fonction);
    }

    @Override
    public String toString() {
        return "Operateur{} " + super.toString();
    }
}

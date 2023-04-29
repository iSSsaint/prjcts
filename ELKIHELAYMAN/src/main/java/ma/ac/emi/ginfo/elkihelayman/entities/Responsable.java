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
public class Responsable extends Employe{

    @JsonIgnore
    @OneToMany(mappedBy = "responsable", cascade = CascadeType.DETACH)
    private List<Modele> modeles = new ArrayList<>();

    public Responsable(String nom, String prenom, String fonction) {
        super(nom, prenom, fonction);
    }

    @Override
    public String toString() {
        return "Responsable{} " + super.toString();
    }
}

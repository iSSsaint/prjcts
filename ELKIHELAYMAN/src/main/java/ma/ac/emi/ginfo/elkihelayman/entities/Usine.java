package ma.ac.emi.ginfo.elkihelayman.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String pays;
    private String ville;


    @JsonIgnore
    @OneToMany(mappedBy = "usine", cascade = CascadeType.DETACH)
    private List<Employe> employes = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "usine", cascade = CascadeType.ALL)
    private List<Modele> modeles = new ArrayList<>();



    public Usine(String nom, String pays, String ville) {
        this.nom = nom;
        this.pays = pays;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Usine{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}

package ma.ac.emi.ginfo.elkihelayman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    private String prenom;

    private String fonction;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usine_id")
    private Usine usine;



    public Employe(String nom, String prenom, String fonction) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", fonction='" + fonction + '\'' +
                ", usine=" + usine +
                '}';
    }
}

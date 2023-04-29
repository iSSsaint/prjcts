package ma.ac.emi.ginfo.elkihelayman.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, length = 100)
    private String code;

    private int puissance;
    private int poids;

    private LocalDate debutFabrication;
    private LocalDate finFabrication;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usine_id")
    private Usine usine;

    @JsonIgnore
    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL)
    private List<Moteur> moteurs = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;




    public Modele(String code, int puissance, int poids, LocalDate debutFabrication, LocalDate finFabrication) {
        this.code = code;
        this.puissance = puissance;
        this.poids = poids;
        this.debutFabrication = debutFabrication;
        this.finFabrication = finFabrication;
    }

    @Override
    public String toString() {
        return "Modele{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", puissance=" + puissance +
                ", poids=" + poids +
                ", debutFabrication=" + debutFabrication +
                ", finFabrication=" + finFabrication +
                ", usine=" + usine +
                ", responsable=" + responsable +
                '}';
    }
}

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
public class Moteur {
    @Id
    @Column(name = "numero_serie", nullable = false)
    private Integer numeroSerie;

    private int kilometrage;

    private LocalDate miseEnService;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modele_code")
    private Modele modele;


    @JsonIgnore
    @OneToMany(mappedBy = "moteur", cascade = CascadeType.ALL)
    private List<Defaut> defauts = new ArrayList<>();



    public Moteur(Integer numeroSerie, int kilometrage, LocalDate miseEnService) {
        this.numeroSerie = numeroSerie;
        this.kilometrage = kilometrage;
        this.miseEnService = miseEnService;
    }

    @Override
    public String toString() {
        return "Moteur{" +
                "numeroSerie=" + numeroSerie +
                ", kilometrage=" + kilometrage +
                ", miseEnService=" + miseEnService +
                ", modele=" + modele +
                '}';
    }
}

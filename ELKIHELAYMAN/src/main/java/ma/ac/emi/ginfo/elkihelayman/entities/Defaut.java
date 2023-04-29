package ma.ac.emi.ginfo.elkihelayman.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Defaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;

    private String description;

    private int gravite;

    private int kilometrage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "moteur_numero_serie")
    private Moteur moteur;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_code")
    private Type type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "operateur_id")
    private Operateur operateur;


    public Defaut(LocalDate date, String description, int gravite, int kilometrage) {
        this.date = date;
        this.description = description;
        this.gravite = gravite;
        this.kilometrage = kilometrage;
    }

    @Override
    public String toString() {
        return "Defaut{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", gravite=" + gravite +
                ", kilometrage=" + kilometrage +
                ", moteur=" + moteur +
                ", type=" + type +
                ", operateur=" + operateur +
                '}';
    }
}

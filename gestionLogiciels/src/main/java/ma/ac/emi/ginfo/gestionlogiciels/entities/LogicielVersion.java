package ma.ac.emi.ginfo.gestionlogiciels.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LogicielVersion{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int Majeure;
    private int Mineure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogicielVersion(int majeure, int mineure) {
        Majeure = majeure;
        Mineure = mineure;
    }

    public LogicielVersion() {

    }

    public int getMajeure() {
        return Majeure;
    }

    public void setMajeure(int majeure) {
        Majeure = majeure;
    }

    public int getMineure() {
        return Mineure;
    }

    public void setMineure(int mineure) {
        Mineure = mineure;
    }



    @Override
    public String toString() {
        return "LogicielVersion{" +
                "Majeure=" + Majeure +
                ", Mineure=" + Mineure +
                '}';
    }
}

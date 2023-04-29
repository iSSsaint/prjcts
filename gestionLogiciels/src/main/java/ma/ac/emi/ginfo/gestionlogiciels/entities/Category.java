package ma.ac.emi.ginfo.gestionlogiciels.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "principalCategory")
    private List<Logiciel> logiciel;

    @ManyToMany(mappedBy = "categories")
    private List<Logiciel> logiciels;

    //Constructors
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Logiciel> getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(List<Logiciel> logiciel) {
        this.logiciel = logiciel;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }

    //To String method
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
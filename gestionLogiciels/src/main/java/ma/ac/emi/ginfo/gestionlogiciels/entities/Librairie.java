package ma.ac.emi.ginfo.gestionlogiciels.entities;

import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Librairie extends Logiciel{

    @ManyToMany
    @JoinTable(
            name = "reflexeve_libraries",
            joinColumns = {@JoinColumn(name = "librairie1_version_id"),@JoinColumn(name = "nomLibrairie1")},
            inverseJoinColumns = {@JoinColumn(name = "librairie2_version_id"),@JoinColumn(name = "nomLibrairie2")})
    private List<Librairie> librairies = new ArrayList<>();

    public Librairie() {
        super();
    }

    public Librairie(LogicielId id, String description, URL url) {
        super(id, description, url);
    }

    public List<Librairie> getLibrairies() {
        return librairies;
    }

    public void setLibrairies(List<Librairie> librairies) {
        this.librairies = librairies;
    }

//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("Librairie{");
//        sb.append("Logiciel Id=").append(super.getId()).append(" + \n");
//        sb.append("description=").append(super.getDescription()).append(" + \n");
//        sb.append("librairies=").append(librairies).append(" + \n");
//
//        sb.append('}');
//        return sb.toString();
//    }
}

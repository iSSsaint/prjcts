package ma.ac.emi.ginfo.gestionlogiciels.entities;

import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Application extends Logiciel{

    @Id
    @Column(name = "url", unique = true, nullable = false)
    private URL url = (super.getUrl() == null ? null : super.getUrl());

    @ManyToMany(mappedBy = "applications",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Logiciel> logiciels = new ArrayList<>();

    public Application() {
        super();
    }

    public Application(LogicielId id, String description, URL url) {
        super(id, description, url);
    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public void setUrl(URL url) {
        this.url = url;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }

    @Override
    public String toString() {
        return "Application{" +
                "url=" + url +
                ", logiciels=" + logiciels +
                '}';
    }
}

package ma.ac.emi.ginfo.gestionlogiciels.entities;

import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.ComposantId;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Composant {
    @EmbeddedId
    private ComposantId id;

    private String description;
    private URL url;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "nom"),
            @JoinColumn(name = "logiciel_version_id")
    })
    private Logiciel logicielCp;

    @ManyToMany(mappedBy = "composantsLicense")
    private List<License> licensesComposant = new ArrayList<>();

    public Composant() {
    }

    public Composant(ComposantId id, String description, URL url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }

    public ComposantId getId() {
        return id;
    }

    public void setId(ComposantId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Logiciel getLogicielCp() {
        return logicielCp;
    }

    public void setLogicielCp(Logiciel logicielCp) {
        logicielCp.getComposants().add(this);
        this.logicielCp = logicielCp;
    }

    public List<License> getLicensesComposant() {
        return licensesComposant;
    }

    public void setLicensesComposant(List<License> licensesComposant) {
        this.licensesComposant = licensesComposant;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Composant{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", url=").append(url);
        sb.append(", logicielCp=").append(logicielCp);
        sb.append('}');
        return sb.toString();
    }
}

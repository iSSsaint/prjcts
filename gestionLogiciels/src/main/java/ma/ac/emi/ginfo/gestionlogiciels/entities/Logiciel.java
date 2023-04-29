package ma.ac.emi.ginfo.gestionlogiciels.entities;

import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Logiciel {

    @EmbeddedId
    private LogicielId id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private URL url;


    //Many To One relation ship
    @ManyToOne
    @JoinColumn(name = "principal_category_id")
    private Category principalCategory;

    //Many To Many relation ship
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_category",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_application",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = {@JoinColumn(name = "application_version_id"),@JoinColumn(name = "nomApplication")})
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "logicielCp")
    private List<Composant> composants = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_license",
            joinColumns = {@JoinColumn(name = "logiciel_version_id"),@JoinColumn(name = "nom")},
            inverseJoinColumns = {@JoinColumn(name = "license_nom"),@JoinColumn(name = "license_version_id"),@JoinColumn(name = "license_langue")})
    private List<License> licensesLog = new ArrayList<>();

    public Logiciel() {
    }

    public Logiciel(LogicielId id, String description, URL url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }

    public LogicielId getId() {
        return id;
    }

    public void setId(LogicielId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desciption) {
        this.description = desciption;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Category getPrincipalCategory() {
        return principalCategory;
    }

    public void setPrincipalCategory(Category principalCategory) {
        this.principalCategory = principalCategory;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public List<License> getLicencesLog() {
        return licensesLog;
    }

    public void setLicencesLog(List<License> licensesLog) {
        this.licensesLog = licensesLog;
    }

    @Override
    public String toString() {
        return "Logiciel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", url=" + url +
                ", principalCategory=" + principalCategory +
                ", categories=" + categories +
                '}';
    }
}

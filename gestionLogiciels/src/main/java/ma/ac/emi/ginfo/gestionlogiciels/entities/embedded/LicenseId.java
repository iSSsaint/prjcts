package ma.ac.emi.ginfo.gestionlogiciels.entities.embedded;

import ma.ac.emi.ginfo.gestionlogiciels.entities.LogicielVersion;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class LicenseId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1354755662347158703L;

    private String nom;
    private String langue;
    @ManyToOne
    @JoinColumn(name = "license_version_id")
    private LogicielVersion licenseVersion;

    public LicenseId() {
        super();
    }

    public LicenseId(String nom, String langue, LogicielVersion licenseVersion) {
        this.nom = nom;
        this.langue = langue;
        this.licenseVersion = licenseVersion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LogicielVersion getLicenseVersion() {
        return licenseVersion;
    }

    public void setLicenseVersion(LogicielVersion licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    @Override
    public String toString() {
        return "LicenseId{" +
                "nom='" + nom + '\'' +
                ", licenseVersion=" + licenseVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenseId licenseId)) return false;
        return getNom().equals(licenseId.getNom()) && getLangue().equals(licenseId.getLangue()) && getLicenseVersion().equals(licenseId.getLicenseVersion());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((langue == null) ? 0 : langue.hashCode());
        result = prime * result + ((licenseVersion == null) ? 0 : licenseVersion.hashCode());
        return result;
    }
}

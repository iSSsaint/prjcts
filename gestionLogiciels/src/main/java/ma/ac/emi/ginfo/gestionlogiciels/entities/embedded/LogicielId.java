package ma.ac.emi.ginfo.gestionlogiciels.entities.embedded;

import ma.ac.emi.ginfo.gestionlogiciels.entities.LogicielVersion;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LogicielId implements Serializable {

    private static final long serialVersionUID = 1354755272351750906L;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "logiciel_version_id")
    private LogicielVersion logicielVersion;

    public LogicielId() {
        super();
    }

    public LogicielId(String nom, LogicielVersion logicielVersion) {
        super();
        this.nom = nom;
        this.logicielVersion = logicielVersion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LogicielVersion getVersion() {
        return logicielVersion;
    }

    public void setVersion(LogicielVersion logicielVersion) {
        this.logicielVersion = logicielVersion;
    }

    public LogicielVersion getLogicielVersion() {
        return logicielVersion;
    }

    public void setLogicielVersion(LogicielVersion logicielVersion) {
        this.logicielVersion = logicielVersion;
    }

    @Override
    public String toString() {
        return "LogicielId{" +
                "nom='" + nom + '\'' +
                ", logicielVersion=" + logicielVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicielId that)) return false;
        return getNom().equals(that.getNom()) && getLogicielVersion().equals(that.getLogicielVersion());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((logicielVersion == null) ? 0 : logicielVersion.hashCode());
        return result;
    }
}
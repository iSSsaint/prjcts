package ma.ac.emi.ginfo.gestionlogiciels.entities.embedded;

import ma.ac.emi.ginfo.gestionlogiciels.entities.LogicielVersion;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class ComposantId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1354755562347750806L;

    private String code;
    @ManyToOne
    @JoinColumn(name = "composant_version_id")
    private LogicielVersion composantVersion;

    public ComposantId() {
        super();
    }

    public ComposantId(String code, LogicielVersion composantVersion) {
        super();
        this.code = code;
        this.composantVersion = composantVersion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LogicielVersion getVersion() {
        return composantVersion;
    }

    public void setVersion(LogicielVersion logicielVersion) {
        this.composantVersion = logicielVersion;
    }

    public LogicielVersion getComposantVersion() {
        return composantVersion;
    }

    public void setComposantVersion(LogicielVersion logicielVersion) {
        this.composantVersion = logicielVersion;
    }

    @Override
    public String toString() {
        return "ComposantId{" +
                "code='" + code + '\'' +
                ", logicielVersion=" + composantVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComposantId that)) return false;
        return getCode().equals(that.getCode()) && getComposantVersion().equals(that.getComposantVersion());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((composantVersion == null) ? 0 : composantVersion.hashCode());
        return result;
    }
}

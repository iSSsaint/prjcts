package ma.ac.emi.ginfo.elkihelayman.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Type {

    @Id
    @Column(name = "code", nullable = false)
    private Integer code;

    private String nom;


    @JsonIgnore
    @OneToMany(mappedBy = "type", cascade = CascadeType.DETACH)
    private List<Defaut> defauts = new ArrayList<>();


    public Type(Integer code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Type{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                '}';
    }
}

package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Librairie;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrairieRepository extends JpaRepository<Librairie, LogicielId> {
}
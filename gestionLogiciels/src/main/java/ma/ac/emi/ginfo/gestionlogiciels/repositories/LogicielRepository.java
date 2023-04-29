package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Logiciel;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LogicielId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogicielRepository extends JpaRepository<Logiciel, LogicielId> {
}
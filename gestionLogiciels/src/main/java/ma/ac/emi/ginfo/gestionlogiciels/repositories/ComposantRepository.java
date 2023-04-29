package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Composant;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.ComposantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant, ComposantId> {
}
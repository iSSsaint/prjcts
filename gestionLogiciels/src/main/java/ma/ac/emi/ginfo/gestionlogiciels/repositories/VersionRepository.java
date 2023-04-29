package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.LogicielVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<LogicielVersion, Long> {
}
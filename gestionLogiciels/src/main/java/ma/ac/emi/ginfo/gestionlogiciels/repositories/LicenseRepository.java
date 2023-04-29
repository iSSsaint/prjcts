package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.License;
import ma.ac.emi.ginfo.gestionlogiciels.entities.embedded.LicenseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, LicenseId> {
}
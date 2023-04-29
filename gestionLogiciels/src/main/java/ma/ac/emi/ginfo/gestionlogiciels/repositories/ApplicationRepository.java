package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.net.URL;

@RepositoryRestController
public interface ApplicationRepository extends JpaRepository<Application, URL> {
}
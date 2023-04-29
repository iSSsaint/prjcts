package ma.ac.emi.ginfo.gestionlogiciels.repositories;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
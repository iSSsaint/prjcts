package ma.ac.emi.ginfo.elkihelayman.repositories;

import ma.ac.emi.ginfo.elkihelayman.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
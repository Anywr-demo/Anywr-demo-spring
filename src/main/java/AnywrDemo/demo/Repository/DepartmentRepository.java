package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Departements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departements,Long> {
}

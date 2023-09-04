package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Absences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository  extends JpaRepository<Absences,Long> {
}

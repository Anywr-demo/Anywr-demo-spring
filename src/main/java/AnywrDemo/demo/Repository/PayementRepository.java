package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementRepository extends JpaRepository<Payement,Long> {
}

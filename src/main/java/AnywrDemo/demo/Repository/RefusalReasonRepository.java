package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.RefusalReason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefusalReasonRepository extends JpaRepository<RefusalReason,Long> {


    List<RefusalReason> findByCreatedByCollaborator(Collaborateurs createdByCollaborator);


}

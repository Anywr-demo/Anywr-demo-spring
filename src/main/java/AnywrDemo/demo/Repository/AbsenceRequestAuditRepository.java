package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.AbsenceRequestAudit;
import AnywrDemo.demo.Model.RefusalReason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AbsenceRequestAuditRepository  extends JpaRepository<AbsenceRequestAudit,Long> {
    List<AbsenceRequestAudit> findByRefusalReason(RefusalReason refusalReason);

    Optional<AbsenceRequestAudit> findAbsenceRequestAuditByCollaborateurId(Long id);

    List<AbsenceRequestAudit> findAllByAbsenceRequestCode(String code);


}

package AnywrDemo.demo.Model;

import AnywrDemo.demo.Model.Enum.EtatDemandeAbsence;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Absencerequestaudit")
@Builder
public class AbsenceRequestAudit  extends AbstractEntity{



    @Enumerated(EnumType.STRING)
    private EtatDemandeAbsence stateAbsence;

    @Column(name="codeAbsenceAudit")
    private Long code;


    @ManyToOne
    @JoinColumn(name="idCollaborateur")
    private Collaborateurs collaborateur; // the user who performed the action

    @ManyToOne
    @JoinColumn(name="idAbsences")
    private Absences absenceRequest;

    @ManyToOne
    @JoinColumn(name="refusal_reason_id")
    private RefusalReason refusalReason;







}
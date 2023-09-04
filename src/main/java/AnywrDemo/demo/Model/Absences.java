package AnywrDemo.demo.Model;

import AnywrDemo.demo.Model.Enum.TypeAbsence;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "absences")
public class Absences  extends  AbstractEntity{

    @Column(name="codeAbsence")
    private Long code;


    @Column(name="typeAbsence")
    @Enumerated(EnumType.STRING)
    private TypeAbsence type_absence;

    @Column(name="managerApproval")
    private boolean manager_approval;

    @Column(name="hrApproval")
    private boolean hr_approval;

    @Column(name="datedebut")
    private Date date_debut;
    @Column(name="datefin")
    private Date date_fin;


    @ManyToOne
    @JoinColumn(name="idCollaborateur")
    private Collaborateurs collaborateurId;


    @OneToMany(mappedBy = "absenceRequest" , cascade = CascadeType.ALL)
    private List<AbsenceRequestAudit> AbsenceAudits;

}

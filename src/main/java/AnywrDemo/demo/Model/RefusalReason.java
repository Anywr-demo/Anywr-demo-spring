package AnywrDemo.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="refusal_reason")

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = true)
public class RefusalReason extends AbstractEntity {


    @Column(name="reason_code")
    private String reasonCode;
    @Column(name="reason_description")
    private String reasonDescription;

    @ManyToOne
    @JoinColumn(name = "created_by_collaborator_id")
    private Collaborateurs createdByCollaborator;


}

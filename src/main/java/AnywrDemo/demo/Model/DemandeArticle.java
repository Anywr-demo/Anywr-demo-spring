package AnywrDemo.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demandeArticle")
@EqualsAndHashCode(callSuper = true)

public class DemandeArticle extends AbstractEntity {

    @Column(name="code")
    private String code;


    @Column(name="requestDate")
    private Date date_request;

    @Column(name="isApproved")
    private Boolean is_Approved;


    @ManyToOne
    @JoinColumn(name="collaborateur_id")
    private Collaborateurs collaborateur;


    @OneToMany(mappedBy = "demandeArticle")
    private List<LigneDemandeArticle> LigneDemandeArticles;
}
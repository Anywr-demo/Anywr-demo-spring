package AnywrDemo.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignedemandearticle")
public class LigneDemandeArticle extends AbstractEntity{


    private String code ;

    @ManyToOne
    @JoinColumn(name="idDemandeArticle")
    private DemandeArticle demandeArticle;

    @Column(name="quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name="idArticle")
    private Articles article;
}

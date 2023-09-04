package AnywrDemo.demo.Model;

import AnywrDemo.demo.Model.Enum.TypeMvt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MouvementdeStock")
@EqualsAndHashCode(callSuper = true)
public class MvtDeStock extends AbstractEntity{


    @Column(name="qte")
    private BigDecimal quantite_mouvement;


    @Column(name="datemvt")
    private Instant date_mouvement;


    @Column(name="typeMvt")
    @Enumerated(EnumType.STRING)
    private TypeMvt typeMvtStock;


    @ManyToOne
    @JoinColumn(name="articleId")
    private Articles article;
}

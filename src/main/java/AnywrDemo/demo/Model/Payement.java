package AnywrDemo.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payement")
@EqualsAndHashCode(callSuper = true)
public class Payement extends AbstractEntity {
    @Column(
            name = "taux_horraires"
    )
    private BigDecimal taux_horraire;
    @Column(
            name = "heures_travaillee"
    )
    private BigDecimal heures_travaillees;
    @ManyToOne
    @JoinColumn(
            name = "collaborateur_id"
    )
    private Collaborateurs collaborateurs;
}

package AnywrDemo.demo.Model;

import AnywrDemo.demo.Model.Enum.DepName;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departements")
@EqualsAndHashCode(callSuper = true)
@Builder
public class Departements extends AbstractEntity{
    @Column(name="department_name")
    @Enumerated(EnumType.STRING)
    private DepName depName;

    @OneToMany(mappedBy = "department")
    private List<Collaborateurs> collaborateursList;
}
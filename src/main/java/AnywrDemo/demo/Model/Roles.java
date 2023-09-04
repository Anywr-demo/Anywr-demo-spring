package AnywrDemo.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper = true)
@Builder
public class Roles extends AbstractEntity{

    @Column(name="role_name")
    private String rolename;

    @ManyToMany(mappedBy="roles")
    @JsonIgnore
    private List<Collaborateurs> users;




}

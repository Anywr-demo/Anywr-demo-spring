package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Departements;
import AnywrDemo.demo.Model.Enum.DepName;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class DepartmentDto {

    private Long id;
    private DepName depName;

    private List<CollaboratorDto> collaborateursList;

    public static DepartmentDto fromEntity(Departements department) {
        if (department == null) {
            return null;
        }
       return DepartmentDto.builder()
               .id(department.getId())
               .depName(department.getDepName())
               .build();


    }

    public static Departements toEntity(DepartmentDto departmentdto) {

        if (departmentdto == null) {
            return null;
        }
        Departements departements = new Departements();
        departements.setId(departmentdto.getId());
       departements.setDepName(departmentdto.getDepName());
        return departements;
    }
}

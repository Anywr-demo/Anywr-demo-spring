package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private Long id;
    private String rolename;



    @JsonIgnore
    private CollaboratorDto collaborateur;



    public static RoleDto fromEntity(Roles roles)
    {
        if(roles == null) {
            // TODO Throw an exception

            return null;

        }

        // Role --> RoleDto
        return RoleDto.builder()
                .id(roles.getId())
                .rolename(roles.getRolename())
                .build();
    }

    public  static Roles toEntity(RoleDto roleDto){
        if(roleDto == null)
        {
            return null ;
        }

        Roles role = new Roles();
        role.setId(roleDto.getId());
        role.setRolename(roleDto.getRolename());

        return role;
    }
}

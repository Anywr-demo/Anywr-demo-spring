package AnywrDemo.demo.Services;

import AnywrDemo.demo.Model.Roles;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.RoleDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface RoleService {

    RoleDto save(RoleDto dto);

    RoleDto findById(Long id);

    List<RoleDto> findAll();


    public Roles findByName(String name);
    void delete(Long id);


    void assignRoleToCollaborator(Long userId, List<String> roleName);
    void removeRoleFromCollaborator(Long userId, String roleName);
    Page<CollaboratorDto> getUserRoles(Long userId);

}

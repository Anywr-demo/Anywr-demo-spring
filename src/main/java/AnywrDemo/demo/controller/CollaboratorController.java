package AnywrDemo.demo.controller;

import AnywrDemo.demo.Services.CollaborateurService;
import AnywrDemo.demo.Services.RoleService;
import AnywrDemo.demo.controller.api.CollaboratorApi;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.auth.ChangeMotDePasseUtilisateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollaboratorController implements CollaboratorApi {


    private  CollaborateurService collaborateurService;
    private RoleService roleService;

    @Autowired
    public CollaboratorController(@Qualifier("collaborateurServiceImpl") CollaborateurService collaborateurService , RoleService roleService)
    {
        this.collaborateurService = collaborateurService;
        this.roleService = roleService;
    }

    @Override
    public CollaboratorDto save(@RequestBody CollaboratorDto dto) {
        return collaborateurService.save(dto);
    }

    @Override
    public List<CollaboratorDto> findAll() {
        return collaborateurService.findAll();
    }

    @Override
    public CollaboratorDto findById(@PathVariable Long id) {
        return collaborateurService.findById(id);
    }

    @Override
    public List<CollaboratorDto> findHistoriqueCollabortor(@PathVariable Long id) {
        return null;
    }

    @Override
    public CollaboratorDto findByEmail(String email) {
        return collaborateurService.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        collaborateurService.delete(id);
    }

    @Override
    public CollaboratorDto changerMotDePasse(ChangeMotDePasseUtilisateurDTO dto) {
        return collaborateurService.changerMotDePasse(dto);

    }

    @Override
    public void assignRoleToCollaborator(@PathVariable Long userId,@RequestBody List<String> roleName) {
        roleService.assignRoleToCollaborator(userId,roleName);
    }

    @Override
    public void removeRoleFromCollaborator(@PathVariable Long userId, @PathVariable String roleName) {
        roleService.removeRoleFromCollaborator(userId,roleName);

        System.out.println("Role"+ roleName + "from user ID : " + userId + "has been removed successfully");
    }


}

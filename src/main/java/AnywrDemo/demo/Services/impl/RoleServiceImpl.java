package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Roles;
import AnywrDemo.demo.Repository.CollaboratorRepository;
import AnywrDemo.demo.Repository.RoleRepository;
import AnywrDemo.demo.Services.RoleService;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.RoleDto;
import AnywrDemo.demo.exception.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private CollaboratorRepository collaboratorRepository;
    private RoleRepository roleRepository;

    public RoleServiceImpl(CollaboratorRepository collaboratorRepository, RoleRepository roleRepository) {
        this.collaboratorRepository = collaboratorRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return null;
    }

    @Override
    public RoleDto findById(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public Roles findByName(String name) {
        Roles role = roleRepository.findRoleByRolename(name);
        return role;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void assignRoleToCollaborator(Long collaboratorId,List<String> roleName) {

        Collaborateurs collaborator = collaboratorRepository.findById(collaboratorId)
                .orElseThrow(() -> new EntityNotFoundException("Collaborator not found: " + collaboratorId));


        for (String role : roleName) {
            Roles roles = roleRepository.findRoleByRolename(role);
            if (roles == null) {
                throw new AnywrDemo.demo.exception.EntityNotFoundException("Role not found: " + roleName);
            }
            if(!collaborator.getRoles().contains(role)){

                collaborator.getRoles().add(roles);
            }

        }

        Collaborateurs savedCollab;
        savedCollab = collaboratorRepository.save(collaborator);

        CollaboratorDto.fromEntity(savedCollab);
    }


    @Override
    public void removeRoleFromCollaborator(Long userId, String roleName) {
        // Find the user by userId
        Collaborateurs collaborator = collaboratorRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        // Find the role by roleName
        Roles role = roleRepository.findRoleByRolename(roleName);
        if (role == null) {
            throw new InvalidEntityException("Role not found with name: " + roleName);
        }

        // Remove the role from the collaborator's roles
        collaborator.getRoles().remove(role);

        // Save the updated collaborator
        Collaborateurs savedCollab = collaboratorRepository.save(collaborator);

        // Optionally, you can return the updated collaborator DTO here if needed.
        CollaboratorDto collaboratorDto = CollaboratorDto.fromEntity(savedCollab);
    }


    @Override
    public Page<CollaboratorDto> getUserRoles(Long userId) {
        return null;
    }
}

package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Roles;
import AnywrDemo.demo.Repository.CollaboratorRepository;
import AnywrDemo.demo.Repository.RoleRepository;
import AnywrDemo.demo.Services.CollaborateurService;
import AnywrDemo.demo.Services.RoleService;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.RoleDto;
import AnywrDemo.demo.dto.auth.ChangeMotDePasseUtilisateurDTO;
import AnywrDemo.demo.exception.ErrorCodes;
import AnywrDemo.demo.exception.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollaborateurServiceImpl implements CollaborateurService {

    private CollaboratorRepository  collaboratorRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;


    public CollaborateurServiceImpl(CollaboratorRepository collaboratorRepository, PasswordEncoder passwordEncoder , RoleRepository roleRepository ) {
        this.collaboratorRepository = collaboratorRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;

    }


    @Override
    public CollaboratorDto save(CollaboratorDto dto) {

//        if(userAlreadyExists(dto.getMail())){
//            throw new EntityNotFoundException("Un utilisateur avec le meme mail existe deja ");
//
//        }

            Collaborateurs collab = new Collaborateurs();

            collab.setPrenom(dto.getPrenom() + "" + dto.getNom());
            collab.setMail(dto.getMail());
            collab.setDateNaissance(dto.getDateNaissance());
            collab.setNumTel(dto.getNumTel());
            collab.setAbsenceBalance(dto.getAbsenceBalance());
            collab.setPhoto(dto.getPhoto());
            collab.setPayements(new ArrayList<>());
            collab.setAbsences(new ArrayList<>());
            collab.setArticles(new ArrayList<>());
            //encrypt the password using spring security
            collab.setMotdepasse(passwordEncoder.encode(dto.getMotdepasse()));



        List<Roles> roles = new ArrayList<>();

        // Check if the roles exist and add them to the list

        List<Roles> strRoles = collab.getRoles();

        if (dto.getRoles() != null && !dto.getRoles().isEmpty()) {
            for(RoleDto roleDto : dto.getRoles()) {
                String roleName = roleDto.getRolename();

                switch (roleName){
                    case "MANAGER":
                        Roles managerRole = roleRepository.findRoleByRolename("ROLE_MANAGER");
                        roles.add(managerRole);
                                break;
                    case "RH":
                        Roles rhRole = roleRepository.findRoleByRolename("ROLE_RH");
                        roles.add(rhRole);
                        break;
                    case "EMPLOYEE":
                    default:
                        Roles employeerole = roleRepository.findRoleByRolename("ROLE_EMPLOYEE");
                        roles.add(employeerole);


                }

            }


        } else {
            Roles defaultRole = roleRepository.findRoleByRolename("ROLE_EMPLOYEE");
            roles.add(defaultRole);
        }

        collab.setRoles(roles);



        Collaborateurs savedCollab = collaboratorRepository.save(collab);

        return CollaboratorDto.fromEntity(savedCollab);



    }


    private boolean userAlreadyExists(String email)
    {
        Optional<Collaborateurs> user = collaboratorRepository.findCollaborateursByMail(email);

        return user.isPresent();
    }
    @Override
    public List<CollaboratorDto> findAll() {
         return collaboratorRepository.findAll().stream()
                .map(CollaboratorDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CollaboratorDto findById(Long id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return collaboratorRepository.findById(id)
                .map(CollaboratorDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD"
                        )
                );
    }

    @Override
    public List<CollaboratorDto> findHistoriqueCollabortor(Long id) {
        return null;
    }

    @Override
    public CollaboratorDto findByEmail(String email) {
        return collaboratorRepository.findCollaborateursByMail(email)
                .map(CollaboratorDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD"
                        )
                );
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        collaboratorRepository.deleteById(id);
    }

    @Override
    public CollaboratorDto changerMotDePasse(ChangeMotDePasseUtilisateurDTO dto) {
    validate(dto);
    Optional<Collaborateurs> collab = collaboratorRepository.findById(dto.getId());
    if(collab.isEmpty()){
        log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
        throw new AnywrDemo.demo.exception.EntityNotFoundException("USER NOT FOUND " + dto.getId(),ErrorCodes.COLLABORATEUR_NOT_FOUND);
    }
    Collaborateurs collaborteur = collab.get();
    collaborteur.setMotdepasse(passwordEncoder.encode(dto.getMotDePasse()));
    return CollaboratorDto.fromEntity(
            collaboratorRepository.save(collaborteur)
            );

    }

     public void validate(ChangeMotDePasseUtilisateurDTO dto){
         if(dto == null)
         {
             log.warn("Impossible de modifier le mot de passe avec un object NULL");
             throw new InvalidEntityException("Aucune information n'a ete fourni pour pouvoir change le mot de passe " , ErrorCodes.COLLABORATOR_CHANGEPASSWORD_INVALID);
         }

         if(dto.getId() == null ){
             log.warn("Impossible de modifier le mot de passe avec un Id NULL");
             throw new InvalidEntityException("Id utilisateur Null , impossible de modifier le mot de passe  " , ErrorCodes.COLLABORATOR_CHANGEPASSWORD_INVALID);
         }
         if(!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength((dto.getConfirmMotDePasse())) )
         {
             log.warn("Impossible de modifier le mot de passe avec un mot de passe null ");
             throw new InvalidEntityException("Mot de passe utilisateur null :: impossible de modifier le mot de passe ",  ErrorCodes.COLLABORATOR_CHANGEPASSWORD_INVALID);

         }

         if(!dto.getMotDePasse().equals(dto.getConfirmMotDePasse()))
         {
             log.warn("Impossible de modifier le mot de passe avec un deux mot de passe different");

             throw new InvalidEntityException("Mot de passe utilisateur null :: Impossible de modifier le mot de passe",
                     ErrorCodes.COLLABORATOR_CHANGEPASSWORD_INVALID);
         }

     }



}

package AnywrDemo.demo.controller.api;

import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.auth.ChangeMotDePasseUtilisateurDTO;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

public interface CollaboratorApi {

    @PostMapping(value = Constants.COLLABORATOR_ENDPOINT + "/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('RH')")
    CollaboratorDto save (@RequestBody CollaboratorDto dto);


    @GetMapping(value = Constants.COLLABORATOR_ENDPOINT + "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('RH')")
    List<CollaboratorDto> findAll();


    @GetMapping(value = Constants.COLLABORATOR_ENDPOINT + "{idCollaborator}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('RH')")
    CollaboratorDto findById(@PathVariable("idCollaborator") Long idCollaborator);

    @GetMapping(value = Constants.COLLABORATOR_ENDPOINT + "/Historique/{idCollaborator}")
    List<CollaboratorDto> findHistoriqueCollabortor(@PathVariable("idCollaborator") Long idCollaborator);


    @GetMapping(value = Constants.COLLABORATOR_ENDPOINT + "/mail/{mail}")
    @PreAuthorize("hasAnyRole('RH','MANAGER')")
    public CollaboratorDto findByEmail(@PathVariable("mail") String email);

    @DeleteMapping(value = Constants.COLLABORATOR_ENDPOINT + "/delete/{idCollaborator}")
    @PreAuthorize("hasAnyRole('ROLE_RH')")
    void delete (@PathVariable("idCollaborator") Long id);


    @PostMapping(Constants.PASSWORD_RESET + "/update/password")
    CollaboratorDto changerMotDePasse(@RequestBody ChangeMotDePasseUtilisateurDTO dto);

    @PutMapping(value =Constants.ROLESET_COLLABORATOR + "/role/{userId}/assign-roles", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    void assignRoleToCollaborator(@PathVariable Long userId,@RequestBody List<String> roleName);

    @PutMapping(value = Constants.ROLESET_COLLABORATOR + "role-remove/{userId}/{roleName}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    void removeRoleFromCollaborator(@PathVariable Long userId,@PathVariable String roleName);



}

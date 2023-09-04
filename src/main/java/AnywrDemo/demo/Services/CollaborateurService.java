package AnywrDemo.demo.Services;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.auth.ChangeMotDePasseUtilisateurDTO;

import java.util.List;

public interface CollaborateurService {

    CollaboratorDto save (CollaboratorDto dto);


    List<CollaboratorDto> findAll();


    CollaboratorDto findById(Long id);

    List<CollaboratorDto> findHistoriqueCollabortor(Long id);

    public CollaboratorDto findByEmail(String email);

    void delete (Long id);

    CollaboratorDto changerMotDePasse(ChangeMotDePasseUtilisateurDTO dto);

}

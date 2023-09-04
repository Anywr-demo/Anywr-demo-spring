package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Services.CollaborateurService;
import AnywrDemo.demo.dto.CollaboratorDto;
import AnywrDemo.demo.dto.auth.ChangeMotDePasseUtilisateurDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MANAGERServiceImpl implements CollaborateurService {
    @Override
    public CollaboratorDto save(CollaboratorDto dto) {
        return null;
    }

    @Override
    public List<CollaboratorDto> findAll() {
        return null;
    }

    @Override
    public CollaboratorDto findById(Long id) {
        return null;
    }

    @Override
    public List<CollaboratorDto> findHistoriqueCollabortor(Long id) {
        return null;
    }

    @Override
    public CollaboratorDto findByEmail(String email) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CollaboratorDto changerMotDePasse(ChangeMotDePasseUtilisateurDTO dto) {
        return null;
    }
}

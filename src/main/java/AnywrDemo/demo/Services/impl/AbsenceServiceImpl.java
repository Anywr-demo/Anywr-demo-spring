package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Repository.AbsenceRepository;
import AnywrDemo.demo.Repository.CollaboratorRepository;
import AnywrDemo.demo.Services.AbsenceService;
import AnywrDemo.demo.dto.AbsenceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;

    private CollaboratorRepository collaboratorRepository;

    public AbsenceServiceImpl(AbsenceRepository absenceRepository, CollaboratorRepository collaboratorRepository) {
        this.absenceRepository = absenceRepository;
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public AbsenceDto save(AbsenceDto dto) {

        return AbsenceDto.fromEntity(
                absenceRepository.save(
                        AbsenceDto.toEntity(dto)
                )
        );
    }

    @Override
    public List<AbsenceDto> findAll() {

        return absenceRepository.findAll().stream()
                .map(AbsenceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AbsenceDto findById(Long id) {
        if( id == null )
        {
            log.error("Absence ID not found ");
            return null;
        }

        return absenceRepository.findById(id).map(AbsenceDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun absence avec cet ID = " + id + "n'a ete trouve dans le BDD")
        );
    }

    @Override
    public List<AbsenceDto> findHistoriqueAbsence(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

        if(id == null )
        {
            log.error("Absence ID is null");
            return ;
        }


        absenceRepository.deleteById(id);
    }
}

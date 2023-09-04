package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Repository.*;
import AnywrDemo.demo.Services.AbsenceRequestAuditService;
import AnywrDemo.demo.dto.AbsenceAuditDto;
import AnywrDemo.demo.dto.RefusalReasonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AbsenceRequestAuditImpl implements AbsenceRequestAuditService {

    private AbsenceRequestAuditRepository absenceRequestAuditRepository;

    private AbsenceRepository absenceRepository;


    private RefusalReasonRepository refusalReasonRepository;

   private CollaboratorRepository collaboratorRepository;

    public AbsenceRequestAuditImpl(AbsenceRequestAuditRepository absenceRequestAuditRepository, AbsenceRepository absenceRepository, RefusalReasonRepository refusalReasonRepository, CollaboratorRepository collaboratorRepository) {
        this.absenceRequestAuditRepository = absenceRequestAuditRepository;
        this.absenceRepository = absenceRepository;
        this.refusalReasonRepository = refusalReasonRepository;
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public AbsenceAuditDto save(AbsenceAuditDto dto) {
            return AbsenceAuditDto.fromEntity(
                    absenceRequestAuditRepository.save(
                            AbsenceAuditDto.toEntity(dto)
                    )
            );
    }

    @Override
    public AbsenceAuditDto findById(Integer id) {
        return null;
    }

    @Override
    public AbsenceAuditDto findByCodeAbsenceAudit(String codeArticle) {
        return null;
    }

    @Override
    public List<AbsenceAuditDto> findAll() {
        return null;
    }

    @Override
    public List<AbsenceAuditDto> findHistoriqueAbsenceAudit(Long idAbsenceAudit) {
        return null;
    }

    @Override
    public List<AbsenceAuditDto> findByAbsenceAuditDtosByRefusalReason() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

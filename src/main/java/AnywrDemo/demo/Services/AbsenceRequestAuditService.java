package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.AbsenceAuditDto;

import java.util.List;

public interface AbsenceRequestAuditService{

    AbsenceAuditDto save(AbsenceAuditDto dto);

    AbsenceAuditDto findById(Integer id);

    AbsenceAuditDto findByCodeAbsenceAudit(String codeArticle);

    List<AbsenceAuditDto> findAll();

    List<AbsenceAuditDto> findHistoriqueAbsenceAudit(Long idAbsenceAudit);



    List<AbsenceAuditDto> findByAbsenceAuditDtosByRefusalReason();

    void delete(Integer id);
}

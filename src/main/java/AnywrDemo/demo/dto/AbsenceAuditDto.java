package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.AbsenceRequestAudit;
import AnywrDemo.demo.Model.Absences;
import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Enum.EtatDemandeAbsence;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AbsenceAuditDto {

    private Long code;

    private Long id ;

    private EtatDemandeAbsence stateAbsence;



    private CollaboratorDto collaborateur; // the user who performed the action


    private AbsenceDto absenceRequest;

    private RefusalReasonDto refusalReason;


    public static AbsenceAuditDto fromEntity(AbsenceRequestAudit absenceRequestAudit)
    {
        if(absenceRequestAudit == null )
        {
            return null;
        }

        return AbsenceAuditDto.builder()
                .code(absenceRequestAudit.getCode())
                .id(absenceRequestAudit.getId())
                .stateAbsence(absenceRequestAudit.getStateAbsence())
                .absenceRequest(AbsenceDto.fromEntity(absenceRequestAudit.getAbsenceRequest()))
                .refusalReason(RefusalReasonDto.fromEntity(absenceRequestAudit.getRefusalReason()))

                .collaborateur(CollaboratorDto.fromEntity(absenceRequestAudit.getCollaborateur()))
                        .build();
    }

    public  static AbsenceRequestAudit toEntity(AbsenceAuditDto absenceAuditDto)
    {
        if(absenceAuditDto == null )
        {
            return null;
        }

        AbsenceRequestAudit absenceAudit = new AbsenceRequestAudit();
        absenceAudit.setCode(absenceAuditDto.getCode());
        absenceAudit.setId(absenceAuditDto.getId());
        absenceAudit.setStateAbsence(absenceAuditDto.getStateAbsence());
        absenceAudit.setCollaborateur(CollaboratorDto.toEntity(absenceAuditDto.getCollaborateur()));
        absenceAudit.setAbsenceRequest(AbsenceDto.toEntity(absenceAuditDto.getAbsenceRequest()));
        absenceAudit.setRefusalReason(RefusalReasonDto.toEntity(absenceAuditDto.getRefusalReason()));

        return absenceAudit;
    }
}

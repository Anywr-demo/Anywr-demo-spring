package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.AbsenceRequestAudit;
import AnywrDemo.demo.Model.Absences;
import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Enum.TypeAbsence;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class AbsenceDto {

    private  Long id;

    private Long code;


    private TypeAbsence type_absence;

    private boolean manager_approval;

    private boolean hr_approval;

    private Date date_debut;
     private Date date_fin;



    private CollaboratorDto collaborateurId;


    private List<AbsenceAuditDto> AbsenceAudits;




    public static AbsenceDto fromEntity(Absences absence) {
        if (absence == null) {
            return null;
        }
        return AbsenceDto.builder()
                .id(absence.getId())
                .code(absence.getCode())
                .date_debut(absence.getDate_debut())
                .date_fin(absence.getDate_fin())
                .type_absence(absence.getType_absence())
                .hr_approval(absence.isManager_approval())
                .manager_approval(absence.isManager_approval())
                .collaborateurId(CollaboratorDto.fromEntity(absence.getCollaborateurId()))
                .build();
    }

    public static Absences toEntity(AbsenceDto dto) {
        if (dto == null) {
            return null;
        }
        Absences absences = new Absences();
        absences.setId(dto.getId());
        absences.setCode(dto.getCode());
        absences.setDate_debut(dto.getDate_debut());
        absences.setDate_fin(dto.getDate_fin());
        absences.setType_absence(dto.getType_absence());
        absences.setCollaborateurId(CollaboratorDto.toEntity(dto.getCollaborateurId()));

        return absences;
    }

}

package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.RefusalReason;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;


@Builder
@Data
public class RefusalReasonDto {

    private Long id;


    private String reasonCode;

    private String reasonDescription;

    private CollaboratorDto collaborator;


    public static RefusalReasonDto fromEntity(RefusalReason rReason)
    {
        if(rReason == null)
        {
            return null;
        }
        return RefusalReasonDto.builder()
                .id(rReason.getId())
                .reasonCode(rReason.getReasonCode())
                .reasonDescription(rReason.getReasonDescription())
                .collaborator(CollaboratorDto.fromEntity(rReason.getCreatedByCollaborator()))
                .build();
    }

    public static RefusalReason toEntity(RefusalReasonDto dto)
    {
        if(dto == null )
        {
            return null;
        }

        RefusalReason rReason = new RefusalReason();

        rReason.setId(dto.getId());
        rReason.setReasonCode(dto.getReasonCode());
        rReason.setReasonDescription(dto.getReasonDescription());
        rReason.setCreatedByCollaborator(CollaboratorDto.toEntity(dto.getCollaborator()));
        return rReason;
    }
}

package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Payement;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Data
public class PayementDto {

    private Long id;

    private BigDecimal taux_horraire;

    private BigDecimal heures_travaillees;

    private CollaboratorDto collaborateurs;


    public static PayementDto fromEntity(Payement payement)
    {
        if(payement == null)
        {
            return null;
        }
        return PayementDto.builder()
                .id(payement.getId())
                .heures_travaillees(payement.getHeures_travaillees())
                .taux_horraire(payement.getTaux_horraire())
                .collaborateurs(CollaboratorDto.fromEntity(payement.getCollaborateurs()))
                .build();
    }


    public static Payement toEntity(PayementDto dto)
    {
        if(dto == null ){
            return null;
        }

        Payement paie= new Payement();

        paie.setId(dto.getId());
        paie.setHeures_travaillees(dto.getHeures_travaillees());
        paie.setTaux_horraire(dto.getTaux_horraire());
        paie.setCollaborateurs(CollaboratorDto.toEntity(dto.getCollaborateurs()));

        return paie;
    }

}

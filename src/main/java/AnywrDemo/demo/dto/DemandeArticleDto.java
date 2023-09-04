package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.DemandeArticle;
import AnywrDemo.demo.Model.LigneDemandeArticle;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Builder
@Data
public class DemandeArticleDto {

    private Long id;
    private String code;


    private Date date_request;

    private Boolean is_Approved;


    private CollaboratorDto collaborateur;


    private List<LigneDemandeArticleDto> LigneDemandeArticles;



    public static DemandeArticleDto fromEntity(DemandeArticle demandeArticle)
    {
        if(demandeArticle == null )
        {
            return null;
        }

        return DemandeArticleDto.builder()
                .id(demandeArticle.getId())
                .code(demandeArticle.getCode())
                .date_request(demandeArticle.getDate_request())
                .is_Approved(demandeArticle.getIs_Approved())
                .collaborateur(CollaboratorDto.fromEntity(demandeArticle.getCollaborateur()))
                .build();
    }


    public static DemandeArticle toEntity(DemandeArticleDto dto )
    {
        if(dto == null )

        {
            return null;
        }

        DemandeArticle demandeArticle = new DemandeArticle();
        demandeArticle.setId(dto.getId());
        demandeArticle.setCode(dto.getCode());
        demandeArticle.setDate_request(dto.getDate_request());
        demandeArticle.setIs_Approved(dto.getIs_Approved());
        demandeArticle.setCollaborateur(CollaboratorDto.toEntity(dto.getCollaborateur()));

        return demandeArticle;
    }


}

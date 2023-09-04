package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Model.DemandeArticle;
import AnywrDemo.demo.Model.LigneDemandeArticle;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@Data
@Builder
public class LigneDemandeArticleDto {

    private Long id;

    private String code;

    private DemandeArticleDto demandeArticle;


    private BigDecimal quantite;


    private ArticleDto article;

    public static LigneDemandeArticleDto fromEntity(LigneDemandeArticle lda)
    {
        if(lda == null ) {
            return null ;
        }

        return LigneDemandeArticleDto.builder()
                .id(lda.getId())
                .code(lda.getCode())
                .quantite(lda.getQuantite())
                .article(ArticleDto.fromEntity(lda.getArticle()))
                .demandeArticle(DemandeArticleDto.fromEntity(lda.getDemandeArticle()))
                .build();
    }


    public static LigneDemandeArticle toEntity(LigneDemandeArticleDto dto)
    {
        if(dto == null ){
            return null ;
        }

         LigneDemandeArticle ligneDemandeArticle = new LigneDemandeArticle();
        ligneDemandeArticle.setId(dto.getId());
        ligneDemandeArticle.setDemandeArticle(DemandeArticleDto.toEntity(dto.getDemandeArticle()));
        ligneDemandeArticle.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneDemandeArticle.setQuantite(dto.getQuantite());
        ligneDemandeArticle.setCode(dto.getCode());


        return ligneDemandeArticle;

    }
}

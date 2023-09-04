package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Model.Enum.TypeMvt;
import AnywrDemo.demo.Model.MvtDeStock;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtDeStkDto {

    private Long id;

    private BigDecimal quantite_mouvement;


    private Instant date_mouvement;


    private TypeMvt typeMvtStock;



    private ArticleDto article;


    public static MvtDeStkDto fromEntity(MvtDeStock mvtDeStock)
    {
        if(mvtDeStock == null )
        {
            return null ;
        }

        return MvtDeStkDto.builder()
                .id(mvtDeStock.getId())
                .date_mouvement(mvtDeStock.getDate_mouvement())
                .quantite_mouvement(mvtDeStock.getQuantite_mouvement())
                 .typeMvtStock(mvtDeStock.getTypeMvtStock())
                .article(ArticleDto.fromEntity(mvtDeStock.getArticle()))
                .build();
    }



    public static MvtDeStock toEntity(MvtDeStkDto dto)
    {
        if(dto == null )
        {
            return null ;
        }

        MvtDeStock mvtDeStock = new MvtDeStock();
         mvtDeStock.setTypeMvtStock(dto.getTypeMvtStock());
         mvtDeStock.setId(dto.getId());
         mvtDeStock.setDate_mouvement(dto.getDate_mouvement());
         mvtDeStock.setArticle(ArticleDto.toEntity(dto.getArticle()));

         return mvtDeStock;
    }
}

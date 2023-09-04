package AnywrDemo.demo.dto;


import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.Enum.Categorie;
import AnywrDemo.demo.Model.LigneDemandeArticle;
import AnywrDemo.demo.Model.MvtDeStock;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class ArticleDto {

    private  Long id;

    private Long codeArticle;

    private String nomArticle;

    private String description;

    private String photo;

    private Categorie category;


    private Integer quantite_stock;


    private List<LigneDemandeArticleDto> ligneDemandeArticles;
    private List<MvtDeStkDto> mvtdeStocksList;

    private CollaboratorDto collaborateurs;


    public static ArticleDto fromEntity(Articles articles)
    {
        if(articles == null )
        {
            return null;
        }

        return ArticleDto.builder()
                .id(articles.getId())
                .nomArticle(articles.getNomArticle())
                .codeArticle(articles.getCodeArticle())
                .photo(articles.getPhoto())
                .category(articles.getCategory())
                .description(articles.getDescription())
                .quantite_stock(articles.getQuantite_stock())
                .collaborateurs(CollaboratorDto.fromEntity(articles.getCollaborateurs()))
                .build();
    }


    public static Articles toEntity(ArticleDto dto)
    {
        if(dto == null )
        {
            return null ;
        }

         Articles articles = new Articles();
        articles.setId(dto.getId());
        articles.setCodeArticle(dto.getCodeArticle());
        articles.setNomArticle(dto.getNomArticle());
        articles.setCategory(dto.getCategory());
        articles.setQuantite_stock(dto.getQuantite_stock());
        articles.setDescription(dto.getDescription());
        articles.setPhoto(dto.getPhoto());
        articles.setCollaborateurs(CollaboratorDto.toEntity(dto.getCollaborateurs()));

        return articles;
    }
}

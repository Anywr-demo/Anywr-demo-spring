package AnywrDemo.demo.Model;

import AnywrDemo.demo.Model.Enum.Categorie;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
@EqualsAndHashCode(callSuper = true)
public class Articles extends AbstractEntity{

    private Long codeArticle;

    private String nomArticle;

    private String photo;

    private String description;


    @Enumerated(EnumType.STRING)
    private Categorie category;


    private Integer quantite_stock;


    @OneToMany(mappedBy = "article")
    private List<LigneDemandeArticle> ligneDemandeArticles;
    @OneToMany(mappedBy = "article")
    private List<MvtDeStock> mvtdeStocksList;

    @ManyToOne
    @JoinColumn(name="idCollaborateur")
    private Collaborateurs collaborateurs;
}

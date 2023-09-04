package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Model.Enum.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository  extends JpaRepository<Articles,Long> {

    Optional<Articles> findArticleByCodeArticle(String codeArticle);

    List<Articles> findAllByCategory(Categorie categorieName);

}

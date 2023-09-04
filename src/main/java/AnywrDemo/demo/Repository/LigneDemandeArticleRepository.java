package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.LigneDemandeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneDemandeArticleRepository extends JpaRepository<LigneDemandeArticle,Long> {

    List<LigneDemandeArticle> findAllByDemandeArticleId(Long id);

    List<LigneDemandeArticle> findAllByArticleId(Long id);
}

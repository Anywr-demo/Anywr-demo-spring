package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.DemandeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DemandeArticleRepository extends JpaRepository<DemandeArticle,Long> {

    Optional<DemandeArticle> findDemandeArticleByCode(String code);

    List<DemandeArticle> findAllByCollaborateurId(Long id);
}

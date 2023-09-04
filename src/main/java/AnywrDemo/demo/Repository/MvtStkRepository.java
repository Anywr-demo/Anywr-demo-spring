package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.MvtDeStock;
import AnywrDemo.demo.dto.MvtDeStkDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface MvtStkRepository extends JpaRepository<MvtDeStock,Long> {

    @Query("select sum(m.quantite_mouvement) from MvtDeStock m where m.article.id = :idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Long  idArticle);
}

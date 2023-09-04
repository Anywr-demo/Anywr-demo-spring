package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto dto);


    List<ArticleDto> findAll();


    ArticleDto findById(Long id);

    List<ArticleDto> findHistoriqueArticle(Long id);

    void delete (Long id);
}

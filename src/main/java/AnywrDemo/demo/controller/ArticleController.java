package AnywrDemo.demo.controller;


import AnywrDemo.demo.Services.ArticleService;
import AnywrDemo.demo.controller.api.ArticleApi;
import AnywrDemo.demo.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(
            ArticleService articleService
    ) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public ArticleDto findById(Long id) {
        return articleService.findById(id);

    }

    @Override
    public List<ArticleDto> findHistoriqueArticle(Long id) {
        return articleService.findHistoriqueArticle(id);
    }

    @Override
    public void delete(Long id) {
        articleService.delete(id);
    }
}

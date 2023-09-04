package AnywrDemo.demo.controller.api;


import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArticleApi {

    @PostMapping(value = Constants.APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save (@RequestBody ArticleDto dto);


    @GetMapping(value = Constants.APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();


    @GetMapping(value = Constants.APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Long id);

    @GetMapping(value = Constants.APP_ROOT + "/articles/historique/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)

    List<ArticleDto> findHistoriqueArticle(@PathVariable("idArticle") Long idArticle);


    @DeleteMapping(value = Constants.APP_ROOT + "/articles/delete/{idArticle}")
    void delete (@PathVariable("idArticle") Long id);
}

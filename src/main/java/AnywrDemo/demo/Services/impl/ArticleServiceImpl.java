package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Model.Articles;
import AnywrDemo.demo.Repository.ArticleRepository;
import AnywrDemo.demo.Repository.CollaboratorRepository;
import AnywrDemo.demo.Repository.DemandeArticleRepository;
import AnywrDemo.demo.Services.ArticleService;
import AnywrDemo.demo.Validators.ArticleValidator;
import AnywrDemo.demo.dto.ArticleDto;
import AnywrDemo.demo.exception.ErrorCodes;
import AnywrDemo.demo.exception.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private CollaboratorRepository collaboratorRepository;

    private DemandeArticleRepository demandeArticleRepository;


    public ArticleServiceImpl(ArticleRepository articleRepository, CollaboratorRepository collaboratorRepository, DemandeArticleRepository demandeArticleRepository) {
        this.articleRepository = articleRepository;
        this.collaboratorRepository = collaboratorRepository;
        this.demandeArticleRepository = demandeArticleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);

        if(!errors.isEmpty())
        {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        );
    }

    @Override
    public List<ArticleDto> findAll() {

        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto findById(Long id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD"
                        )
        );
    }

    @Override
    public List<ArticleDto> findHistoriqueArticle(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {


        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        articleRepository.deleteById(id);
    }
}

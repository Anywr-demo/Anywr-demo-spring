package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.ArticleDto;
import AnywrDemo.demo.dto.CollaboratorDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null )
        {
            errors.add("Veuillez renseigner le code Article");
            errors.add("veuillez renseigner le nom de l'article ");
            errors.add("veuillez renseigner le description de l'article ");
            errors.add("veuillez renseigner la photo de l'article ");
            errors.add("veuillez renseigner la categorie de l'article ");



        }

        if(!StringUtils.hasLength(String.valueOf(dto.getCodeArticle())))
        {
            errors.add("Veuillez renseigner le code Article");
        }

        if(!StringUtils.hasLength(dto.getNomArticle()))
        {
            errors.add("veuillez renseigner le nom de l'article ");
        }


        if(!StringUtils.hasLength(dto.getDescription()))
        {
            errors.add("veuillez renseigner le description de l'article ");
        }

        if(dto.getCategory() == null )

        {
            errors.add("veuillez renseigner la categorie de l'article ");
        }

        if(!StringUtils.hasLength(dto.getPhoto()))
        {
            errors.add("veuillez renseigner la photo de l'article ");
        }
        return errors;
    }

}


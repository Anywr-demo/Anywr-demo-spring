package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.ArticleDto;
import AnywrDemo.demo.dto.DemandeArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DemandeArticleValidator {


        public static List<String> validate(DemandeArticleDto dto) {
            List<String> errors = new ArrayList<>();

            if (dto == null) {
                errors.add("Veuillez renseigner le code De la Demande d'article");
                errors.add("veuillez renseigner la date du demande");
                errors.add("Veuillez verifier qu'il approuvé ou pas ");
                errors.add("Veuillez renseigner le collaborateur");

            }
            if (!StringUtils.hasLength(dto.getCode()))
            {
                errors.add("Veuillez renseigner le code De la Demande d'article");

            }

            if(dto.getDate_request() == null)

            {
                errors.add("Veuillez renseigner la date de la reservation ");

            }


            if(!dto.getIs_Approved() )
            {
                errors.add("Veuillez renseigner la date de la reservation ");
            }

            if(dto.getCollaborateur() == null || dto.getCollaborateur().getId() == null )
            {
                errors.add("Veuillez renseigner le collaborateur");
            }

            return errors;

        }
}

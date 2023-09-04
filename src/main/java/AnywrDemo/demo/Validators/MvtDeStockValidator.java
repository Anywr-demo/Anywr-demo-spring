package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.DemandeArticleDto;
import AnywrDemo.demo.dto.MvtDeStkDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MvtDeStockValidator {

    public static List<String> validate(MvtDeStkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
            errors.add("Veuillez renseigner la quantite du mouvenent");
            errors.add("Veuillez renseigner type de mouvement");
            errors.add("Veuillez renseigner l'article  au  mouvement");

            return errors;
        }
        if (!StringUtils.hasLength(dto.getTypeMvtStock().name()))
        {
            errors.add("Veuillez renseigner le type Du mouvement");

        }

        if(dto.getDate_mouvement() == null)

        {
            errors.add("Veuillez renseigner la date du mouvement ");

        }

        if(dto.getQuantite_mouvement() == null)

        {
            errors.add("Veuillez renseigner la Quantite du mouvement ");

        }
        if(dto.getArticle() == null)

        {
            errors.add("Veuillez renseigner l'article  au  mouvement ");

        }

        return errors;

    }
}

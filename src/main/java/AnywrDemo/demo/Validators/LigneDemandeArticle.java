package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.DemandeArticleDto;
import AnywrDemo.demo.dto.LigneDemandeArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneDemandeArticle {

    public static List<String> validate(LigneDemandeArticleDto dto) {
        List<String> errors = new ArrayList<>();
        return errors;
    }

}

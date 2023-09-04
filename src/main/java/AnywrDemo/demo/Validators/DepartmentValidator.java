package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.DemandeArticleDto;
import AnywrDemo.demo.dto.DepartmentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartmentValidator {

    public static List<String> validate(DepartmentDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le code De la Demande d'article");


        }
        if (!StringUtils.hasLength(dto.getDepName().name()))
        {
            errors.add("Veuillez renseigner le code De la Demande d'article");

        }


        return errors;

    }
}

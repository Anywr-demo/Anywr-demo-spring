package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.MvtDeStkDto;
import AnywrDemo.demo.dto.PayementDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PayementValidator {

    public static List<String> validate(PayementDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner taux d'horaire");
            errors.add("Veuillez renseigner heures_travaillé ");
            errors.add("Veuillez renseigner le collaborateur");

            return errors;
        }
        if (dto.getTaux_horraire() == null )
        {
            errors.add("Veuillez renseigner le taux d'horraires");

        }

        if(dto.getHeures_travaillees() == null)

        {
            errors.add("Veuillez renseigner heures travaillée ");

        }

        if(dto.getCollaborateurs() == null)

        {
            errors.add("Veuillez renseigner le collaborateur ");

        }

        return errors;

    }
}

package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.MvtDeStkDto;
import AnywrDemo.demo.dto.RefusalReasonDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RefusalReasonValidator {

    public static List<String> validate(RefusalReasonDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le code de refus");
            errors.add("Veuillez renseigner la raison de refus");


            return errors;
        }
        if (!StringUtils.hasLength(dto.getReasonCode()))
        {
            errors.add("Veuillez renseigner le code  du refus");

        }

        if(dto.getReasonDescription() == null)

        {
            errors.add("Veuillez renseigner la description du refus");

        }

        return errors;

    }
}

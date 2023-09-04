package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.AbsenceAuditDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AbsenceRequestAuditValidator {

    public static List<String> validate (AbsenceAuditDto dto)
    {
        List<String> error = new ArrayList<>();

        if( dto == null || !StringUtils.hasLength(String.valueOf(dto.getCode()))){
            error.add("Veuillez renseigner le code de l'Audit");
        }

        return error;
    }
}

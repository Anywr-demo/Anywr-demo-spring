package AnywrDemo.demo.Validators;

import AnywrDemo.demo.dto.CollaboratorDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorValidator {

    public static List<String> validate (CollaboratorDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null )
        {
            errors.add("Veuillez Renseigner le nom d'utilisateur");
            errors.add("Veuillez Renseigner le Prenom d'utilisateur");
            errors.add("Veuillez Renseigner le Mail d'utilisateur");

            errors.add("Veuillez Renseigner le Mot de passe de l'utilisateur");

            errors.add("Veuillez Renseigner le num de téléphone  d'utilisateur");




        }
        if(dto.getDateNaissance() == null )
        {
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez Renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez Renseigner le Prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("Veuillez Renseigner le Mail d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getMotdepasse())) {
            errors.add("Veuillez Renseigner le Mot de passe de l'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez Renseigner le num de téléphone  d'utilisateur");
        }
        return errors;
    }
}

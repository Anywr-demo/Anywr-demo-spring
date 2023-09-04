package AnywrDemo.demo.dto.auth;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangeMotDePasseUtilisateurDTO {

    private Long id;

    private String email;

    private String motDePasse;

    private String confirmMotDePasse;


}

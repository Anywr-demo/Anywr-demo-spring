package AnywrDemo.demo.dto.auth;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthenticationResponse {

    private String accessToken;
    private Long id;
    private String email;
    private List<String> roles;
    private String message;


    public AuthenticationResponse(String accessToken, Long id, String email,  List<String> roles , String message) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.message = message;
    }


}
